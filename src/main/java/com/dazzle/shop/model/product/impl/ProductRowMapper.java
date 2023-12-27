package com.dazzle.shop.model.product.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.product.ProductColorVO;
import com.dazzle.shop.model.product.ProductService;
import com.dazzle.shop.model.product.ProductVO;

@Component
public class ProductRowMapper implements RowMapper<ProductVO> {

	@Autowired
	private ProductService product_service;

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
		vo.setSub_category_num(rs.getInt("sub_category_num"));

//		List<ProductColorVO> colors = product_service.product_colors(rs.getInt("product_num"));
		List<ProductColorVO> colors = null;
		if (product_service != null) {
			colors = product_service.product_colors(rs.getInt("product_num"));
		}
		vo.setColors(colors);

		return vo;
	}

}