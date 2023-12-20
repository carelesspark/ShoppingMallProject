package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.SubCategoryVO;

public class SubCategoryMapper implements RowMapper<SubCategoryVO>{

	@Override
	public SubCategoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SubCategoryVO vo = new SubCategoryVO();
		
		vo.setSub_category_num(rs.getInt(1));
		vo.setSub_category_name(rs.getString(2));
		vo.setSub_category_code(rs.getString(3));
		vo.setCategory_num(rs.getInt(4));
		
		return vo;
	}

	
}
