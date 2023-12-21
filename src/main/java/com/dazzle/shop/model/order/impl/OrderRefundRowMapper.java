package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class OrderRefundRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO orderRefund = new OrderVO();
		orderRefund.setOrder_num(rs.getInt("order_num"));
		orderRefund.setRecipient(rs.getString("recipient"));
		orderRefund.setAmount(rs.getInt("amount"));
		orderRefund.setAmountMultiPrice(rs.getInt("total_price"));
		orderRefund.setProduct_price(rs.getInt("product_price"));
		orderRefund.setOrder_detail_num(rs.getInt("order_detail_num"));
		

		return orderRefund;
	}

	
	
}
