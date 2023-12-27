package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.ProductCodeVO;

public class ProductCodeRowMapper implements RowMapper<ProductCodeVO>{

	@Override
	public ProductCodeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductCodeVO vo = new ProductCodeVO();
		
		vo.setProduct_code(rs.getInt("product_code"));
		vo.setSize_num(rs.getInt("size_num"));
		
		return vo;
	}

}
