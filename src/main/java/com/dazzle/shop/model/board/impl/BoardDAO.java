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

import com.dazzle.shop.model.board.BoardVO;
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
	
	public List<BoardVO> getNoticeList() {	// 공지사항
		String sql = "select * from board where cate = 'notice' order by pno desc";
		
		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());
		
		return boardList;
	}
	
	public List<BoardVO> getQuestList() {	// 문의사항
		String sql = "select * from board where cate = 'quest' order by pno desc";
		
		List<BoardVO> boardList = template.query(sql, new BoardRowMapper());
		
		return boardList;
	}
	
	public BoardVO getBoard(BoardVO vo) {	// 게시판 조회
		String sql = "select * from board where pno = ?";
		
		Object[] args = { vo.getPno() };
		
		BoardVO board = template.queryForObject(sql, args, new BoardRowMapper());
		
		return board;
	}
	
	public List<ReplyVO> getReply(BoardVO vo) {	// 댓글 조회
		String sql = "select * from reply where pno = ? order by rno desc";
		
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
	
	public void writeReply(ReplyVO vo) {	// 댓글 작성
		String sql = "insert into reply (pno, user_num, rcontent) values (?, '1', ?)";
		
		template.update(sql, vo.getPno(), vo.getRcontent());
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
		String sql = "delete from reply where pno = ?";
		
		template.update(sql, vo.getPno());
		
		sql = "delete from board where pno =?";
		
		template.update(sql, vo.getPno());
	}
	
	public void deleteReply(ReplyVO vo) {	// 댓글 삭제
		String sql = "delete from reply where rno = ?";
		
		template.update(sql, vo.getRno());
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
}
