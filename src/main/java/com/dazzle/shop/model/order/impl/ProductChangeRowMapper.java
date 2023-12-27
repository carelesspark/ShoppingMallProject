package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class ProductChangeRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO productChange = new OrderVO();
		productChange.setOrder_num(rs.getInt("order_num"));
		productChange.setProduct_name(rs.getString("product_name"));
		productChange.setRecipient(rs.getString("recipient"));
		productChange.setPhone_num(rs.getString("phone_num"));
		productChange.setAddress(rs.getString("address"));
		productChange.setDetail_address(rs.getString("detail_address"));
		productChange.setAmount(rs.getInt("amount"));
		productChange.setOrder_detail_num(rs.getInt("order_detail_num"));
		

		return productChange;
	}

	
	
}
