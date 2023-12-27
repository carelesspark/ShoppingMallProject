package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.ProductsVO;

public class ProductsRowMapper implements RowMapper<ProductsVO>{

	@Override
	public ProductsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductsVO vo = new ProductsVO();
		
		vo.setProduct_num(rs.getInt("product_num"));
		vo.setProduct_name(rs.getString("product_name"));
		vo.setProduct_price(rs.getInt("product_price"));
		vo.setMain_img(rs.getString("main_img"));
		
		return vo;
	}

	
}
