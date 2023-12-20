package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class SuccessPageRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO successOrderList = new OrderVO();
		successOrderList.setOrder_num(rs.getInt("order_num"));
		successOrderList.setOrder_date(rs.getTimestamp("order_date"));
		successOrderList.setMain_img(rs.getString("main_img"));
		successOrderList.setColor_name(rs.getString("color_name"));
		successOrderList.setSize_name(rs.getString("size_name"));
		successOrderList.setProduct_price(rs.getInt("product_price"));
		successOrderList.setAmount(rs.getInt("amount"));
		successOrderList.setAmountMultiPrice(rs.getInt("total_price"));
		successOrderList.setProduct_name(rs.getString("product_name"));
		successOrderList.setDelivery_price(rs.getInt("delivery_price"));
		
		
		
		
		
		
		
		return successOrderList;
	}

	
	
}
