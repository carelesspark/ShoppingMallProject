package com.dazzle.shop.model.user.persistence;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.order.OrderVO;
import com.dazzle.shop.model.order.impl.OrderListRowMapper;
import com.dazzle.shop.model.user.domain.UserOrdersVO;
import com.dazzle.shop.model.user.domain.UserReviewVO;
import com.dazzle.shop.model.user.domain.UserVO;

@Repository("userDAO")
public class UserDAO {

	@Autowired
	private JdbcTemplate template;

	public final String USER_CARD = "select user_rank, user_point from user_info where user_num = ?";

	private final String ORDER_LIST = "SELECT d.delivery_date, o.order_date, o.recipient, o.order_num, pimg.main_img, p.product_price,"
			+ " od.product_state, od.amount, od.total_price, ps.size_name, pcolor.color_name, p.product_name"
			+ " FROM orders o INNER JOIN delivery d ON o.order_num = d.order_num "
			+ " INNER JOIN order_detail od ON o.order_num = od.order_num "
			+ " INNER JOIN product_code pc ON od.product_code = pc.product_code"
			+ " INNER JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " INNER JOIN product_color pcolor ON ps.color_num = pcolor.color_num "
			+ " INNER JOIN product p ON pcolor.product_num = p.product_num "
			+ " INNER JOIN product_img pimg ON pimg.product_num = p.product_num" + " WHERE o.user_num = ?";

	private final String ORDER_LIST_SEARCH = "SELECT d.delivery_date, o.order_date, o.recipient, o.order_num, pimg.main_img, p.product_price," + 
			" od.product_state, od.amount, od.total_price, ps.size_name, pcolor.color_name, p.product_name" + 
			" FROM orders o INNER JOIN delivery d ON o.order_num = d.order_num" + 
			" INNER JOIN order_detail od ON o.order_num = od.order_num" + 
			" INNER JOIN product_code pc ON od.product_code = pc.product_code" + 
			" INNER JOIN product_size ps ON ps.size_num = pc.size_num" + 
			" INNER JOIN product_color pcolor ON ps.color_num = pcolor.color_num" + 
			" INNER JOIN product p ON pcolor.product_num = p.product_num" + 
			" INNER JOIN product_img pimg ON pimg.product_num = p.product_num" + 
			" WHERE o.user_num = ? AND p.product_name LIKE '%||?||%'";

	private final String ORDER_CHECK = "SELECT" + " (SELECT COUNT(*) FROM orders WHERE user_num = ?) AS total_orders,"
			+ " (SELECT COUNT(*) FROM orders o INNER JOIN order_detail od ON o.order_num = od.order_num WHERE user_num = ? AND od.product_state = '상품 준비 중') AS orders_in_preparation,"
			+ " (SELECT COUNT(*) FROM orders o INNER JOIN order_detail od ON o.order_num = od.order_num WHERE user_num = ? AND od.product_state = '배송 중') AS orders_in_delivery,"
			+ " (SELECT COUNT(*) FROM orders o INNER JOIN order_detail od ON o.order_num = od.order_num WHERE user_num = ? AND od.product_state = '배송 완료') AS orders_delivered";

	private final String ORDER_LIST2 = "SELECT d.delivery_date, o.order_date, o.recipient, o.order_num, pimg.main_img, p.product_price,"
			+ " od.product_state, od.amount, od.total_price, ps.size_name, pcolor.color_name, p.product_name"
			+ " FROM orders o INNER JOIN delivery d ON o.order_num = d.order_num "
			+ " INNER JOIN order_detail od ON o.order_num = od.order_num "
			+ " INNER JOIN product_code pc ON od.product_code = pc.product_code"
			+ " INNER JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " INNER JOIN product_color pcolor ON ps.color_num = pcolor.color_num "
			+ " INNER JOIN product p ON pcolor.product_num = p.product_num "
			+ " INNER JOIN product_img pimg ON pimg.product_num = p.product_num"
			+ " WHERE o.user_num = ? AND o.order_date >= DATE_SUB(NOW(), INTERVAL ? MONTH)";

	private final String REVIEW_LIST = "SELECT r.review_ratings, r.review_date, r.review_clicks, p.product_name, p.product_num "
			+ "FROM review r INNER JOIN product_code pc ON r.product_code = pc.product_code "
			+ "INNER JOIN product_size ps ON pc.size_num = ps.size_num "
			+ "INNER JOIN product_color pcolor ON ps.color_num = pcolor.color_num "
			+ "INNER JOIN product p ON pcolor.product_num = p.product_num WHERE r.user_num = ?";

	/*
	 * 유저 카드 내용 저장
	 */
	public UserVO getUserCard(int user_num) {
		try {
			return template.queryForObject(USER_CARD, new Object[] { user_num }, new UserCardRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return new UserVO();
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

	/*
	 * 주문/배송 조회
	 */
	public List<UserOrdersVO> getUserOrderList(int user_num, UserOrdersVO vo) {
		try {
			if (vo.getSearch_order().equals("")) {
				return template.query(ORDER_LIST, new Object[] { user_num }, new UserOrderRowMapper());
			} else {
				return template.query(ORDER_LIST_SEARCH, new Object[] { user_num, vo.getSearch_order() }, new UserOrderRowMapper());
			}
		} catch (EmptyResultDataAccessException e) {

			return Collections.emptyList();
		}
	}

	public List<UserOrdersVO> getOrderList2(int user_num, int date) {
		try {
			System.out.println("getOrderList2()");
			Object[] args = { user_num, date };
			return template.query(ORDER_LIST2, args, new UserOrderRowMapper());

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/*
	 * 포인트
	 */

	/*
	 * 상품 후기
	 */
	public List<UserReviewVO> getUserReviewList(int user_num) {

		try {

//			return template.query(ORDER_LIST, new Object[] { user_num }, new UserOrderRowMapper());

			return null;
		} catch (EmptyResultDataAccessException e) {

			return Collections.emptyList();
		}
	}
}
