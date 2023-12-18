package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class OrderListRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO orderList = new OrderVO();
		orderList.setOrder_num(rs.getInt("order_num"));
		orderList.setProduct_state(rs.getString("product_state"));
		orderList.setDelivery_date(rs.getTimestamp("delivery_date"));
		orderList.setProduct_name(rs.getString("product_name"));
		orderList.setProduct_price(rs.getInt("product_price"));
		
		return orderList;
	}

	
	
}
