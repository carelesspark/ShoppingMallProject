package com.dazzle.shop.model.product.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.ProductVO;

public class ProductRowMapper implements RowMapper<ProductVO> {

	@Override
	public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductVO vo = new ProductVO();

		Date product_date = rs.getDate("product_date");
		Date modify_date = rs.getDate("modify_date");
		Date delete_date = rs.getDate("delete_date");

		vo.setProduct_num(rs.getInt("product_num"));
		vo.setProduct_name(rs.getString("product_name"));
		vo.setProduct_info(rs.getString("product_info"));
		vo.setProduct_date(product_date);
		vo.setProduct_sell(rs.getInt("product_sell"));
		vo.setProduct_price(rs.getInt("product_price"));
		vo.setModify_date(modify_date);
		vo.setDelete_date(delete_date);
		vo.setRegistration_status(rs.getInt("registration_status"));
		vo.setProduct_class_code(rs.getString("product_class_code"));
		vo.setSub_category_num(rs.getInt("sub_category_num"));

		return vo;
	}

}