package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.UserOrdersVO;

public class OrderCheckRowMapper implements RowMapper<UserOrdersVO> {

	@Override
	public UserOrdersVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserOrdersVO orderCheck = new UserOrdersVO();
		
		orderCheck.setTotal_orders(rs.getInt("total_orders"));
		orderCheck.setOrders_in_preparation(rs.getInt("orders_in_preparation"));
		orderCheck.setOrders_in_delivery(rs.getInt("orders_in_delivery"));
		orderCheck.setOrders_delivered(rs.getInt("orders_delivered"));
		
		return orderCheck;
	}

}
