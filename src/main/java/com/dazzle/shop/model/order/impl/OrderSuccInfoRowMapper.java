package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class OrderSuccInfoRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO orderInfo = new OrderVO();
		orderInfo.setOrder_num(rs.getInt("order_num"));		
		orderInfo.setOrder_date(rs.getTimestamp("order_date"));
		orderInfo.setAddress(rs.getString("address"));
		orderInfo.setDetail_address(rs.getString("detail_address"));
		orderInfo.setPostal_num(rs.getString("postal_num"));
		orderInfo.setDelivery_price(rs.getInt("delivery_price"));
		orderInfo.setRecipient(rs.getString("recipient"));
		orderInfo.setRequest(rs.getString("request"));
		orderInfo.setPayment(rs.getString("payment"));
		orderInfo.setPhone_num(rs.getString("phone_num"));
		return orderInfo;
	}

	
	
}
