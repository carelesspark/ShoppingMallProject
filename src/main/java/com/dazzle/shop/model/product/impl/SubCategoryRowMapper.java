package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.SubCategoryVO;

public class SubCategoryRowMapper implements RowMapper<SubCategoryVO>{

	@Override
	public SubCategoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SubCategoryVO vo = new SubCategoryVO();
		
		vo.setSub_category_num(rs.getInt("sub_category_num"));
		vo.setSub_category_name(rs.getString("sub_category_name"));
		vo.setCategory_num(rs.getInt("category_num"));
		
		return vo;
	}

	
}
