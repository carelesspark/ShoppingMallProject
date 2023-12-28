package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dazzle.shop.model.product.ProductImgVO;

public class ProductImgRowMapper implements RowMapper<ProductImgVO>{

	@Override
	public ProductImgVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductImgVO vo = new ProductImgVO();
		
		vo.setImg_num(rs.getInt("img_num"));
		vo.setProduct_num(rs.getInt("product_num"));
		vo.setImg_name(rs.getString("img_name"));
		vo.setImg_type(rs.getInt("img_type"));
		
		return vo;
	}

}
