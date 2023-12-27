package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.CategoryVO;

public class CategoryRowMapper implements RowMapper<CategoryVO>{

	@Override
	public CategoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CategoryVO vo = new CategoryVO();
		
		vo.setCategory_num(rs.getInt("category_num"));
		vo.setCategory_name(rs.getString("category_name"));
			
		return vo;
	}

	
}
