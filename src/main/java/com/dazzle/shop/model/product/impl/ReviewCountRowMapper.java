package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.ReviewVO;

public class ReviewCountRowMapper implements RowMapper<ReviewVO>{

	@Override
	public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ReviewVO vo = new ReviewVO();
		
		vo.setCount(rs.getInt("count"));
		return vo;
	}

	
}
