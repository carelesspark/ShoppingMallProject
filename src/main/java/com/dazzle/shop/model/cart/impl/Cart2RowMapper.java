package com.dazzle.shop.model.cart.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.cart.CartVO;


public class Cart2RowMapper implements RowMapper<CartVO>{

	@Override
	public CartVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartVO cart = new CartVO();
		cart.setCart_num(rs.getInt("cart_num"));
		cart.setProduct_code(rs.getInt("product_code"));
		cart.setAmount(rs.getInt("amount"));		
		cart.setUser_num(rs.getInt("user_num"));
		
		return cart;

	}
	
}
