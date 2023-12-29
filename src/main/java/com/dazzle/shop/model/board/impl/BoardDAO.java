package com.dazzle.shop.model.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dazzle.shop.model.board.BoardProductVO;
import com.dazzle.shop.model.board.BoardVO;
import com.dazzle.shop.model.board.FileVO;
import com.dazzle.shop.model.board.PVO;
import com.dazzle.shop.model.board.ReplyVO;

@Repository("boardDAO")
public class BoardDAO {
	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	private final String select = "select * from users right join board on board.user_num = users.user_num left join codi_ctgr on board.ctgr_num = codi_ctgr.ctgr_num";

	public List<BoardVO> getBoardList() { // 게시판
		String sql = "select * from users right join board on board.user_num = users.user_num left join codi_ctgr on board.ctgr_num = codi_ctgr.ctgr_num where cate = 'board' order by pno desc";

		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());

		return boardList;
	}

	public List<FileVO> getFileList() {
		String sql = "select * from file, board where file.pno = board.pno group by file.pno order by file.pno desc";

		List<FileVO> fileList = template.query(sql, new FileRowMapper());

		return fileList;
	}

	public List<FileVO> getFileList(int ctgr_num) {
		String sql = "select * from file, board where file.pno = board.pno and ctgr_num = " + ctgr_num
				+ " group by file.pno order by file.pno desc";

		List<FileVO> fileList = template.query(sql, new FileRowMapper());

		return fileList;
	}

	public List<BoardVO> getCtgrBoardList(int ctgr_num) { // 게시판 카테고리별 보기
		String sql = "select * from users right join board on board.user_num = users.user_num left join codi_ctgr on board.ctgr_num = codi_ctgr.ctgr_num where cate = 'board' and board.ctgr_num = "
				+ ctgr_num + " order by pno desc";

		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());

		return boardList;
	}

	public List<BoardVO> getNoticeList(int pageNum) { // 공지사항
		String sql = select + " where cate = 'notice' order by pno desc limit 15 offset " + ((pageNum - 1) * 15);

		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());

		return boardList;
	}

	public Integer getNoticeTotalPage() {
		String sql = "select count(*) from board where cate = 'notice'";

		Integer count = template.queryForObject(sql, Integer.class);

		return count;
	}

	public List<BoardVO> getQuestList(int pageNum) { // 문의사항
		String sql = select + " where cate = 'quest' order by pno desc limit 15 offset " + ((pageNum - 1) * 15);

		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());

		return boardList;
	}

	public Integer getQuestTotalPage() {
		String sql = "select count(*) from board where cate = 'quest'";

		Integer count = template.queryForObject(sql, Integer.class);

		return count;
	}

	public BoardVO getBoard(BoardVO vo) { // 게시판 조회
		String sql = "select * from users right join board on users.user_num = board.user_num left join codi_ctgr on board.ctgr_num = codi_ctgr.ctgr_num where pno = ?";

		Object[] args = { vo.getPno() };

		BoardVO board = template.queryForObject(sql, args, new BoardRowMapper());

		return board;
	}

	public List<FileVO> getFile(BoardVO vo) {
		String sql = "select * from file where pno = ?";

		Object[] args = { vo.getPno() };

		List<FileVO> file = template.query(sql, args, new FileRowMapper());

		return file;
	}

	public List<ReplyVO> getReply(BoardVO vo) { // 댓글 조회
		String sql = "select * from reply r join users u on u.user_num = r.user_num where pno = ? order by rno";

		Object[] args = { vo.getPno() };

		List<ReplyVO> replyList = template.query(sql, args, new ReplyRowMapper());

		return replyList;
	}

	public BoardVO getNotice(BoardVO vo) { // 공지사항 조회
		String sql = select + " where pno = ?";

		Object[] args = { vo.getPno() };

		BoardVO board = template.queryForObject(sql, args, new BoardRowMapper());

		return board;
	}

	public BoardVO getQuest(BoardVO vo) { // 문의사항 조회
		String sql = select + " where pno = ?";

		Object[] args = { vo.getPno() };

		BoardVO board = template.queryForObject(sql, args, new BoardRowMapper());

		return board;
	}

	public ReplyVO getQuestReply(BoardVO vo) { // 문의 답변 조회
		String sql = "select * from reply where pno = ?";

		Object[] args = { vo.getPno() };

		ReplyVO reply = template.queryForObject(sql, args, new ReplyRowMapper());

		return reply;
	}

	public int writeBoard(BoardVO vo) { // 게시판 작성
		String sql = "insert into board (user_num, ctgr_num, title, cate, posttime) values (?, ?, ?, 'board', now())";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, vo.getUserNum());
				pstmt.setInt(2, vo.getCtgr_num());
				pstmt.setString(3, vo.getTitle());

				return pstmt;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	public List<PVO> getProductList() {
		String sql = "select product_num, product_name from product";

		List<PVO> productList = template.query(sql, new PRowMapper());

		return productList;
	}

	public void insertBoardImg(int pno, String mainImageName) {
		String sql = "insert into file (pno, fname) values (?, ?)";

		try {
			template.update(sql, pno, mainImageName);
		} catch (DataAccessException e) {
			e.printStackTrace();
			System.err.println("DAO 실패");
		}

	}

	public void insertPNum(BoardProductVO vo) {
		String sql = "insert into board_product_num (pno, product_num) values (?, ?)";

		template.update(sql, vo.getPno(), vo.getProduct_num());
	}

	public void writeReply(ReplyVO vo) { // 댓글 작성
		String sql = "insert into reply (pno, user_num, rcontent) values (?, ?, ?)";

		template.update(sql, vo.getPno(), vo.getUserNum(), vo.getRcontent());
	}

	public Integer ckQuestReply(ReplyVO vo) {
		String sql = "select count(*) from reply where pno =" + vo.getPno();

		Integer count = template.queryForObject(sql, Integer.class);

		return count;
	}

	public void writeNotice(BoardVO vo) { // 공지사항 작성
		String sql = "insert into board (user_num, title, cate, posttime, content) values (?, ?, 'notice', now(), ?)";

		template.update(sql, vo.getUserNum(), vo.getTitle(), vo.getContent());
	}

	public void writeQuest(BoardVO vo) { // 문의사항 작성
		String sql = "insert into board (user_num, title, cate, posttime, content) values (?, ?, 'quest', now(), ?)";

		template.update(sql, vo.getUserNum(), vo.getTitle(), vo.getContent());
	}

	public void deleteBoard(BoardVO vo) { // 게시글 삭제
		String sql = "delete from board where pno =?";

		template.update(sql, vo.getPno());
	}

	public void deleteReply(ReplyVO vo) { // 댓글 삭제
		String sql = "delete from reply where rno = ?";

		template.update(sql, vo.getRno());
	}

	public void deleteQuestReply(ReplyVO vo) {
		String sql = "delete from reply where pno = ?";

		template.update(sql, vo.getPno());
	}

	public void deleteNotice(BoardVO vo) { // 공지사항 삭제
		String sql = "delete from board where pno = ?";

		template.update(sql, vo.getPno());
	}

	public void deleteQuest(BoardVO vo) { // 문의사항 삭제
		String sql = "delete from reply where pno = ?";

		template.update(sql, vo.getPno());

		sql = "delete from board where pno = ?";

		template.update(sql, vo.getPno());
	}

	public void editBoard(BoardVO vo) { // 게시글 수정
		String sql = "update board set ctgr_num = ?, title = ?, posttime = now() where pno = ?";

		template.update(sql, vo.getCtgr_num(), vo.getTitle(), vo.getPno());
	}

	public void updateBoardImg(int pno, String mainImageName) {
		String sql = "update file set fname = ? where pno = ?";

		try {
			template.update(sql, mainImageName, pno);
		} catch (DataAccessException e) {
			e.printStackTrace();
			System.err.println("DAO 실패");
		}

	}

	public void editNotice(BoardVO vo) { // 공지사항 수정
		String sql = "update board set title = ?, posttime = now(), content = ? where pno = ?";

		template.update(sql, vo.getTitle(), vo.getContent(), vo.getPno());
	}

	public void editQuest(BoardVO vo) { // 문의사항 수정
		String sql = "update board set title = ?, posttime = now(), content = ? where pno = ?";

		template.update(sql, vo.getTitle(), vo.getContent(), vo.getPno());
	}

	//////////////////////////////
	public String getCate(int pno) {
		String sql = "select cate from board where pno = " + pno;

		return template.queryForObject(sql, String.class);
	}
}
