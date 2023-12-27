package com.dazzle.shop.model.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dazzle.shop.model.board.BoardProCodeVO;
import com.dazzle.shop.model.board.BoardVO;
import com.dazzle.shop.model.board.CateVO;
import com.dazzle.shop.model.board.FileVO;
import com.dazzle.shop.model.board.ReplyVO;

@Repository("boardDAO")
public class BoardDAO {
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public List<BoardVO> getBoardList() {	// 게시판
		String sql = "select * from board where cate = 'board' order by pno desc";
		
		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());
		
		return boardList;
	}
	
	public List<BoardVO> getBoardCateList(String ctgr_name) {	// 게시판 카테고리 나누기
		String sql = "select * from board inner join codi_ctgr ON board.pno = codi_ctgr.pno WHERE codi_ctgr.ctgr_name = '" + ctgr_name  +"'";
		
		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());
		
		return boardList;
	}
	
	public List<FileVO> getFile() {
		String sql = "select * from file where forder = 1 order by fno desc";
		
		List<FileVO> files = template.query(sql, new FileRowMapper());
		
		return files;
	}
	
	public List<FileVO> getFileList(BoardVO vo) {	// 업로드 된 파일 조회
		String sql = "select * from file where pno = ? order by forder desc";
		
		Object[] args = { vo.getPno() };
		
		List<FileVO> fileList = template.query(sql, args, new FileRowMapper());
		
		return fileList;
	}
	
	public List<BoardVO> getNoticeList(int pageNum) {	// 공지사항
		String sql = "select * from board where cate = 'notice' order by pno desc limit 15 offset " + ((pageNum-1)*15);
		
		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());
		
		return boardList;
	}
	
	public Integer getNoticeTotalPage() {
		String sql = "select count(*) from board where cate = 'notice'";
		
		Integer count = template.queryForObject(sql, Integer.class);
		
		return count;
	}
	
	public List<BoardVO> getQuestList(int pageNum) {	// 문의사항
		String sql = "select * from board where cate = 'quest' order by pno desc limit 15 offset " + ((pageNum - 1)*15);
		
		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());
		
		return boardList;
	}
	
	public Integer getQuestTotalPage() {
		String sql = "select count(*) from board where cate = 'quest'";
		
		Integer count = template.queryForObject(sql, Integer.class);
		
		return count;
	}
	
	public BoardVO getBoard(BoardVO vo) {	// 게시판 조회
		String sql = "select * from board where pno = ?";
		
		Object[] args = { vo.getPno() };
		
		BoardVO board = template.queryForObject(sql, args, new BoardRowMapper());
		
		return board;
	}
	
	public CateVO getCate(BoardVO vo) {	// 카테고리 조회
		String sql = "select * from codi_ctgr where pno = ?";
		
		Object[] args = { vo.getPno() };
		
		CateVO cate = template.queryForObject(sql, args, new CateRowMapper());
		
		return cate;
	}
	
	public BoardProCodeVO getCode(BoardVO vo) {
		String sql = "select * from board_productcode where pno = ?";
		
		Object[] args = { vo.getPno() };
		
		BoardProCodeVO code = template.queryForObject(sql, args, new ProCodeRowMapper());
		
		return code;
	}
	
	public List<ReplyVO> getReply(BoardVO vo) {	// 댓글 조회
		String sql = "select * from reply where pno = ? order by rno";
		
		Object[] args = { vo.getPno() };
		
		List<ReplyVO> replyList = template.query(sql, args, new ReplyRowMapper());
		
		return replyList;
	}
	
	public BoardVO getNotice(BoardVO vo) {	// 공지사항 조회
		String sql = "select * from board where pno = ?";
		
		Object[] args = { vo.getPno() };
		
		BoardVO board = template.queryForObject(sql, args, new BoardRowMapper());
		
		return board;
	}
	
	public BoardVO getQuest(BoardVO vo) {	// 문의사항 조회
		String sql = "select * from board where pno = ?";
		
		Object[] args = { vo.getPno() };
		
		BoardVO board = template.queryForObject(sql, args, new BoardRowMapper());
		
		return board;
	}
	
	public ReplyVO getQuestReply(BoardVO vo) {	// 문의 답변 조회
		String sql = "select * from reply where pno = ?";
		
		Object[] args = { vo.getPno() };
		
		ReplyVO reply = template.queryForObject(sql, args, new ReplyRowMapper());
		
		return reply;
	}
	
	public void writeBoard(BoardVO vo) {	// 게시판 작성
		String sql = "insert into board (user_num, title, cate, posttime) values ('1', ?, 'board', now())";
		
		template.update(sql, vo.getTitle());
	}
	
	public void fileUpload(MultipartFile file) {	// 파일 업로드
		String sql = "select pno from board order by pno desc limit 1";
		
		Integer pno = template.queryForObject(sql, Integer.class);
		
		sql = "insert into file (pno, fname) values (" + pno + ", ?)";
		
		template.update(sql, "../resources/image/upload/" + file.getOriginalFilename());
	}
	
	public void insertCate(CateVO vo) {	// 게시물 세부 카테고리
		String sql = "select pno from board order by pno desc limit 1";
		
		Integer pno = template.queryForObject(sql, Integer.class);
		
		sql = "insert into codi_ctgr (pno, ctgr_name) values (" + pno + ", ?)";
		
		template.update(sql, vo.getCtgr_name());
	}
	
	public void insertNullCate(CateVO vo) {	// null 카테고리
		String sql = "select pno from board order by pno desc limit 1";
		
		Integer pno = template.queryForObject(sql, Integer.class);
		
		sql = "insert into codi_ctgr (pno, ctgr_name) values (" + pno + ", NULL)";
		
		template.update(sql);
	}
	
	public void insertProduct_code(BoardProCodeVO vo) {
		String sql = "select pno from board order by pno desc limit 1";
		
		Integer pno = template.queryForObject(sql, Integer.class);
		
		sql = "insert into board_productcode (pno, product_code1, product_code2,  product_code3, product_code4, product_code5) values (" + pno + ", ?, ?, ?, ?, ?)";
		
		System.out.println(vo);
		
		template.update(sql, vo.getProduct_code1(), vo.getProduct_code2(), vo.getProduct_code3(), vo.getProduct_code4(), vo.getProduct_code5());
	}
	
	public void writeReply(ReplyVO vo) {	// 댓글 작성
		String sql = "insert into reply (pno, user_num, rcontent) values (?, '1', ?)";
		
		template.update(sql, vo.getPno(), vo.getRcontent());
	}
	
	public Integer ckQuestReply(ReplyVO vo) {
		String sql = "select count(*) from reply where pno =" + vo.getPno();
		
		Integer count = template.queryForObject(sql, Integer.class);
		
		return count;
	}
	
	public void writeNotice(BoardVO vo) {	// 공지사항 작성
		String sql = "insert into board (user_num, title, cate, posttime, content) values ('1', ?, 'notice', now(), ?)";
		
		template.update(sql, vo.getTitle(), vo.getContent());
	}
	
	public void writeQuest(BoardVO vo) {	// 문의사항 작성
		String sql = "insert into board (user_num, title, cate, posttime, content) values ('1', ?, 'quest', now(), ?)";
		
		template.update(sql, vo.getTitle(), vo.getContent());
	}
	
	public void deleteBoard(BoardVO vo) {	// 게시글 삭제
		String sql = "delete from board where pno =?";
		
		template.update(sql, vo.getPno());
	}
	
	public void deleteReply(ReplyVO vo) {	// 댓글 삭제
		String sql = "delete from reply where rno = ?";
		
		template.update(sql, vo.getRno());
	}
	
	public void deleteQuestReply(ReplyVO vo) {
		String sql = "delete from reply where pno = ?";
		
		template.update(sql, vo.getPno());
	}
	
	public void deleteNotice(BoardVO vo) {	// 공지사항 삭제
		String sql = "delete from board where pno = ?";
		
		template.update(sql, vo.getPno());
	}
	
	public void deleteQuest(BoardVO vo) {	// 문의사항 삭제
		String sql = "delete from reply where pno = ?";
		
		template.update(sql, vo.getPno());
		
		sql = "delete from board where pno = ?";
		
		template.update(sql, vo.getPno());		
	}
	
	public void editBoard(BoardVO vo) {	// 게시글 수정
		String sql = "update board set title = ?, posttime = now() where pno = ?";
		
		template.update(sql, vo.getTitle(), vo.getPno());
	}
	
	public void editBoardNoTag(BoardVO vo) {	// 게시글 수정 상품코드 없음
		String sql = "update board set title = ?, posttime = now(), product_code = NULL where pno = ?";
		
		template.update(sql, vo.getTitle(), vo.getPno());
	}
	
	public void editNotice(BoardVO vo) {	// 공지사항 수정
		String sql = "update board set title = ?, posttime = now(), content = ? where pno = ?";
		
		template.update(sql, vo.getTitle(), vo.getContent(), vo.getPno());
	}
	
	public void editQuest(BoardVO vo) {	// 문의사항 수정
		String sql = "update board set title = ?, posttime = now(), content = ? where pno = ?";
		
		template.update(sql, vo.getTitle(), vo.getContent(), vo.getPno());
	}
}
