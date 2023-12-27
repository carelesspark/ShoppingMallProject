package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dazzle.shop.model.product.ProductColorVO;
import com.dazzle.shop.model.product.ProductService;
import com.dazzle.shop.model.product.ProductSizeVO;

@Component
public class ProductColorRowMapper implements RowMapper<ProductColorVO>{

	@Autowired
	ProductService product_service;
	
	@Override
	public ProductColorVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductColorVO vo = new ProductColorVO();
		
		vo.setColor_num(rs.getInt("color_num"));
		vo.setColor_name(rs.getNString("color_name"));
		vo.setProduct_num(rs.getInt("product_num"));
		
		List<ProductSizeVO> sizes = product_service.product_sizes(rs.getInt("color_num"));
		vo.setSizes(sizes);
		
		return vo;
	}

	
	
}
