package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class UserPointRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO userPoint = new OrderVO();
		userPoint.setUser_point(rs.getInt("user_point"));
		
		return userPoint;
	}

	
	
}
