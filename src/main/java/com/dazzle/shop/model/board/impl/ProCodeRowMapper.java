package com.dazzle.shop.model.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.board.BoardProCodeVO;

public class ProCodeRowMapper implements RowMapper<BoardProCodeVO> {

	@Override
	public BoardProCodeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		BoardProCodeVO vo = new BoardProCodeVO();
		
		vo.setBpno(rs.getInt(1));
		vo.setPno(rs.getInt(2));
		vo.setProduct_code1(rs.getInt(3));
		vo.setProduct_code2(rs.getInt(4));
		vo.setProduct_code3(rs.getInt(5));
		vo.setProduct_code4(rs.getInt(6));
		vo.setProduct_code5(rs.getInt(7));
		
		return vo;
	}

}
