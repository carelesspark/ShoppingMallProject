package com.dazzle.shop.model.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.board.PVO;

public class PRowMapper implements RowMapper<PVO>{

	@Override
	public PVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		PVO vo = new PVO();
		
		vo.setProduct_num(rs.getInt("product_num"));
		vo.setProduct_name(rs.getString("product_name"));
		
		return vo;
	}

}
