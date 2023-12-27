package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dazzle.shop.model.product.ProductSizeVO;

@Component
public class ProductSizeRowMapper implements RowMapper<ProductSizeVO>{

	@Override
	public ProductSizeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductSizeVO vo = new ProductSizeVO();
		
		vo.setSize_num(rs.getInt("size_num"));
		vo.setSize_name(rs.getString("size_name"));
		vo.setProduct_stock(rs.getInt("product_stock"));
		vo.setColor_num(rs.getInt("color_num"));
		
		
		return vo;
	}

}
