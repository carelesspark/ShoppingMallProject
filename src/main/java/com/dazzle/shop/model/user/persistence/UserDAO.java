package com.dazzle.shop.model.user.persistence;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.user.domain.*;

@Repository("userDAO")
public class UserDAO {

	@Autowired
	private JdbcTemplate template;

	// 유저 카드 내용
	private final String USER_CARD = "SELECT SUBSTR(ui.user_rank, 1,1) rank_letter, ui.user_rank, "
			+ "COUNT(case when d.delivery_date IS NULL then 1 ELSE NULL END) delivering_items FROM user_info ui "
			+ "JOIN orders o ON ui.user_num = o.user_num LEFT OUTER JOIN delivery d ON o.order_num = d.order_num "
			+ "GROUP BY ui.user_num having ui.user_num = ?";

	// 나의 쇼핑
	// 주문/배송 조회
	private final String ORDER_LIST = "SELECT o.order_date, d.delivery_date, od.product_state, od.order_detail_num, pc.product_code, "
			+ "od.amount, od.total_price, ps.size_name, pcolor.color_name, p.product_name, p.product_num, o.order_num "
			+ "FROM orders o " + "LEFT JOIN delivery d ON o.order_num = d.order_num "
			+ "JOIN order_detail od ON o.order_num = od.order_num "
			+ "JOIN product_code pc ON od.product_code = pc.product_code "
			+ "JOIN product_size ps ON pc.size_num = ps.size_num "
			+ "JOIN product_color pcolor ON ps.color_num = pcolor.color_num "
			+ "JOIN product p ON pcolor.product_num = p.product_num "
			+ "WHERE o.user_num = ? AND o.order_date BETWEEN ? AND ? ORDER BY o.order_date DESC";

	private final String ORDER_CHECK = "SELECT" + " (SELECT COUNT(*) FROM orders WHERE user_num = ?) AS total_orders,"
			+ " (SELECT COUNT(*) FROM orders o INNER JOIN order_detail od ON o.order_num = od.order_num WHERE user_num = ? AND od.product_state = '상품 준비 중') AS orders_in_preparation,"
			+ " (SELECT COUNT(*) FROM orders o INNER JOIN order_detail od ON o.order_num = od.order_num WHERE user_num = ? AND od.product_state = '배송 중') AS orders_in_delivery,"
			+ " (SELECT COUNT(*) FROM orders o INNER JOIN order_detail od ON o.order_num = od.order_num WHERE user_num = ? AND od.product_state = '배송 완료') AS orders_delivered";

	// 포인트 내역
	private final String POINT_LIST = "SELECT o.order_date, o.order_num, po.point_type, po.points, "
			+ "ps.size_name, pcolor.color_name, p.product_name FROM point po "
			+ "JOIN order_detail od ON po.order_detail_num = od.order_detail_num "
			+ "JOIN orders o ON o.order_num = od.order_num "
			+ "JOIN product_code pc ON od.product_code = pc.product_code "
			+ "JOIN product_size ps ON pc.size_num = ps.size_num "
			+ "JOIN product_color pcolor ON ps.color_num = pcolor.color_num "
			+ "JOIN product p ON pcolor.product_num = p.product_num WHERE po.user_num = ? "
			+ "AND o.order_date BETWEEN ? AND ? ORDER BY o.order_date DESC LIMIT ?, ?";
	// 날짜 사이 포인트 레코드 개수
	private final String COUNT_POINT_LIST_BETWEEN_DATES = "SELECT COUNT(*) FROM point p "
			+ "JOIN order_detail od ON p.order_detail_num = od.order_detail_num JOIN orders o "
			+ "ON od.order_num = o.order_num WHERE p.user_num = ? AND o.order_date BETWEEN ? AND ?";

	// 내가 작성한 리뷰 내역
	private final String REVIEW_LIST = "SELECT r.review_ratings, r.review_date, "
			+ "p.product_name, p.product_num, ps.size_name, pcolor.color_name "
			+ "FROM review r INNER JOIN product_code pc ON r.product_code = pc.product_code "
			+ "JOIN product_size ps ON pc.size_num = ps.size_num JOIN product_color pcolor "
			+ "ON ps.color_num = pcolor.color_num JOIN product p ON pcolor.product_num = p.product_num "
			+ "WHERE r.user_num = ? AND r.review_date BETWEEN ? AND ? ORDER BY r.review_date DESC LIMIT ?, ?";

	// 날짜 기준 리뷰 개수
	private final String COUNT_REVIEW_LIST_BETWEEN_DATES = "SELECT COUNT(*) FROM review r "
			+ "WHERE r.user_num = ? AND r.review_date BETWEEN ? AND ?";

	// 1대1 질의응답 내역
	private final String INQUIRY_LIST = "SELECT i.inquiry_date, i.inquiry_num, ia.answer, i.product_num, "
			+ "p.product_name, pcolor.color_name, ps.size_name " + "FROM inquiry i "
			+ "LEFT OUTER JOIN inquiry_answer ia ON i.inquiry_num = ia.inquiry_num "
			+ "JOIN product p ON p.product_num = i.product_num "
			+ "JOIN product_color pcolor ON pcolor.product_num = p.product_num "
			+ "JOIN product_size ps ON ps.color_num = pcolor.color_num "
			+ "WHERE i.user_num = ? AND i.inquiry_date BETWEEN ? AND ? ORDER BY i.inquiry_date DESC LIMIT ?, ?";
	// 날짜 기준 질의응답 개수
	private final String COUNT_INQUIRY_LIST_BETWEEN_DATES = "SELECT COUNT(*) FROM inquiry "
			+ "WHERE user_num = ? AND inquiry_date BETWEEN ? AND ?";

	// 작성 글
	private final String BOARD_LIST = "SELECT b.pno, b.title, b.cate, b.posttime, COUNT(r.rno) reply_count "
			+ "FROM board b LEFT JOIN reply r ON b.pno = r.pno WHERE b.user_num = ? AND b.posttime BETWEEN ? AND ? "
			+ "GROUP BY b.pno, b.title, b.cate, b.posttime ORDER BY b.pno DESC LIMIT ?, ?";
	// 날짜 기준 작성 글 수
	private final String COUNT_BOARD_LIST_BETWEEN_DATES = "SELECT COUNT(*) FROM board WHERE user_num = ? AND posttime BETWEEN ? AND ?";

	// 작성 댓글
	private final String REPLY_LIST = "SELECT b.cate, b.title, b.pno FROM reply r JOIN board b ON r.pno = b.pno "
			+ "WHERE r.user_num = ? AND b.posttime BETWEEN ? AND ? ORDER BY r.rno DESC LIMIT ?, ?";
	// 날짜 기준 작성 댓글 수
	private final String COUNT_REPLY_LIST_BETWEEN_DATES = "SELECT COUNT(*) FROM reply r JOIN board b ON r.pno = b.pno "
			+ "WHERE r.user_num = ? AND b.posttime BETWEEN ? AND ?";

	// 유저 카드 내용
	public UserCardVO getUserCard(int user_num) {

		try {
			return template.queryForObject(USER_CARD, new Object[] { user_num }, new UserCardRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return new UserCardVO();
		}
	}

	public UserCardVO getUserCard2(int user_num) {
		String sql = "SELECT IFNULL(SUM(p.points), 0) user_total_point FROM point p WHERE p.user_num = ?";

		try {
			return template.queryForObject(sql, new Object[] { user_num }, new UserCard2RowMapper());
		} catch (EmptyResultDataAccessException e) {
			return new UserCardVO();
		}
	}

	/*
	 * 주문/배송 현황(COUNT)
	 */

	public UserOrdersVO orderCheck(int user_num) {
		try {
			System.out.println("orderCheck()");
			Object[] args = { user_num, user_num, user_num, user_num };
			return template.queryForObject(ORDER_CHECK, args, new OrderCheckRowMapper());

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// 나의 쇼핑
	// 주문/배송 조회
	public List<UserOrdersVO> getUserOrderList(UserOrdersVO vo) {
		try {
			return template.query(ORDER_LIST, new Object[] { vo.getUser_num(), vo.getStartDate(), vo.getEndDate() },
					new UserOrderListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 유저 번호와 일치하는 테이블 레코드 수
	public int getRecords(String tableName, int user_num) {
		String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE user_num = " + user_num;

		return template.queryForObject(sql, Integer.class);
	}

	// 나의 혜택
	// 포인트 내역
	public List<UserPointVO> getUserPointList(UserPointVO vo) {
		int offset = (vo.getCurrentPage() - 1) * vo.getItemsPerPage();
		int limit = vo.getItemsPerPage();

		try {
			return template.query(POINT_LIST,
					new Object[] { vo.getUser_num(), vo.getStartDate(), vo.getEndDate(), offset, limit },
					new UserPointListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 특정 날짜 사이의 유저 번호와 일치하는 포인트 테이블 레코드 수
	public int countPointBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {

		return template.queryForObject(COUNT_POINT_LIST_BETWEEN_DATES, Integer.class, user_num, startDate, endDate);
	}

	// 상품 후기
	public List<UserReviewVO> getUserReviewList(UserReviewVO vo) {
		int offset = (vo.getCurrentPage() - 1) * vo.getItemsPerPage();
		int limit = vo.getItemsPerPage();

		try {
			return template.query(REVIEW_LIST,
					new Object[] { vo.getUser_num(), vo.getStartDate(), vo.getEndDate(), offset, limit },
					new UserReviewListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 특정 날짜 사이의 유저 번호와 일치하는 리뷰 테이블 레코드 수
	public int countReviewBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {

		return template.queryForObject(COUNT_REVIEW_LIST_BETWEEN_DATES, Integer.class, user_num, startDate, endDate);
	}

	// 1대1 질문 후기
	public List<UserInquiryVO> getUserInquiryList(UserInquiryVO vo) {
		int offset = (vo.getCurrentPage() - 1) * vo.getItemsPerPage();
		int limit = vo.getItemsPerPage();

		try {
			return template.query(INQUIRY_LIST,
					new Object[] { vo.getUser_num(), vo.getStartDate(), vo.getEndDate(), offset, limit },
					new UserInquiryListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 특정 날짜 사이의 유저 번호와 일치하는 1대1 질문 테이블 레코드 수
	public int countInquiryBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {

		return template.queryForObject(COUNT_INQUIRY_LIST_BETWEEN_DATES, Integer.class, user_num, startDate, endDate);
	}

	// 작성 글
	public List<UserBoardVO> getUserBoardList(UserBoardVO vo) {
		int offset = (vo.getCurrentPage() - 1) * vo.getItemsPerPage();
		int limit = vo.getItemsPerPage();

		try {
			return template.query(BOARD_LIST,
					new Object[] { vo.getUser_num(), vo.getStartDate(), vo.getEndDate(), offset, limit },
					new UserBoardListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 날짜 기준 작성 글 수
	public int countBoardBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {

		return template.queryForObject(COUNT_BOARD_LIST_BETWEEN_DATES, Integer.class, user_num, startDate, endDate);
	}

	// 작성 댓글
	public List<UserReplyVO> getUserReplyList(UserReplyVO vo) {
		int offset = (vo.getCurrentPage() - 1) * vo.getItemsPerPage();
		int limit = vo.getItemsPerPage();

		try {
			return template.query(REPLY_LIST,
					new Object[] { vo.getUser_num(), vo.getStartDate(), vo.getEndDate(), offset, limit },
					new UserReplyListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 날짜 기준 작성 댓글 수
	public int countReplyBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {

		return template.queryForObject(COUNT_REPLY_LIST_BETWEEN_DATES, Integer.class, user_num, startDate, endDate);
	}

	public boolean checkPwd(int user_num, String pwd) {
		String sql = "Select count(*) from auth_id where user_num = ? and pwd = ?";

		RowMapper<Boolean> rowMapper = (rs, rowNum) -> {
			int count = rs.getInt(1);

			return count >= 1;
		};

		try {
			return template.queryForObject(sql, rowMapper, user_num, pwd);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	public UserVO getUserInfo(int user_num) {
		String sql = "select ai.id, ui.user_phone, ai.user_email from user_info ui "
				+ "join auth_id ai on ui.user_num = ai.user_num where ui.user_num = ?";

		RowMapper<UserVO> rowMapper = (rs, rowNum) -> {
			UserVO vo = new UserVO();
			vo.setId(rs.getString("id"));
			vo.setUser_phone(rs.getString("user_phone"));
			vo.setUser_email(rs.getString("user_email"));

			return vo;
		};

		try {
			return template.queryForObject(sql, rowMapper, user_num);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	//////////////////////////////////////////////////////////////////////
	// 회원정보 변경 비동기
	public boolean updatePwd(int user_num, String pwd) {
		String sql = "update auth_id set pwd = '" + pwd + "' where user_num = " + user_num;

		try {
			template.update(sql);

			return true;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}

}
