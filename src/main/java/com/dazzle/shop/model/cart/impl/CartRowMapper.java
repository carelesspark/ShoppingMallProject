package com.dazzle.shop.model.cart.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.cart.CartVO;


public class CartRowMapper implements RowMapper<CartVO>{

	@Override
	public CartVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartVO cart = new CartVO();
		cart.setCart_num(rs.getInt("cart_num"));
		cart.setImg_name(rs.getString("img_name"));
		cart.setProduct_code(rs.getInt("product_code"));
		cart.setProduct_price(rs.getInt("product_price"));
		cart.setTotal_price(rs.getInt("total_price"));
		cart.setAmount(rs.getInt("amount"));		
		cart.setProduct_name(rs.getString("product_name"));
		cart.setColor_name(rs.getString("color_name"));
		cart.setSize_name(rs.getString("size_name"));
		cart.setUser_num(rs.getInt("user_num"));
		
		return cart;

	}
	
}
