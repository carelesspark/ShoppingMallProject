package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class OrderNumRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO ordernum = new OrderVO();
		ordernum.setOrder_num(rs.getInt("order_num"));
		return ordernum;
	}

	
	
}
