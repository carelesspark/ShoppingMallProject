package com.dazzle.shop.model.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		BoardVO vo = new BoardVO();
		
		vo.setPno(rs.getInt("pno"));
		vo.setUserNum(rs.getInt("user_num"));
		vo.setCtgr_num(rs.getInt("ctgr_num"));
		vo.setTitle(rs.getString("title"));
		vo.setCate(rs.getString("cate"));
		vo.setPosttime(rs.getDate("posttime"));
		vo.setContent(rs.getString("content"));
		
		vo.setUser_name(rs.getString("user_name"));
		vo.setCtgr_name(rs.getString("ctgr_name"));
		
		return vo;
	}
	
}
