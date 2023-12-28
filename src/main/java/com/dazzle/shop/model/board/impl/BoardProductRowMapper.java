package com.dazzle.shop.model.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.board.BoardProductVO;

public class BoardProductRowMapper implements RowMapper<BoardProductVO> {

	@Override
	public BoardProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		BoardProductVO vo = new BoardProductVO();
		
		vo.setBpno(rs.getInt(1));
		vo.setPno(rs.getInt(2));
		vo.setProduct_num(rs.getInt(3));
		
		return vo;
	}

}
