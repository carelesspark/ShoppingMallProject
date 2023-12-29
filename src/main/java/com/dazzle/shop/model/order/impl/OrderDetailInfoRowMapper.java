package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class OrderDetailInfoRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO orderInfo = new OrderVO();
		orderInfo.setProduct_num(rs.getInt("product_num"));
		orderInfo.setDelivery_num(rs.getInt("delivery_num"));
		orderInfo.setProduct_name(rs.getString("product_name"));
		orderInfo.setSize_name(rs.getString("size_name"));
		orderInfo.setColor_name(rs.getString("color_name"));
		orderInfo.setAmount(rs.getInt("amount"));
		orderInfo.setProduct_price(rs.getInt("product_price"));
		orderInfo.setOrder_num(rs.getInt("order_num"));
		orderInfo.setProduct_state(rs.getString("product_state"));
		orderInfo.setDelivery_date(rs.getDate("delivery_date"));
		orderInfo.setDelivery_company(rs.getString("delivery_company"));
		orderInfo.setInvoice_num(rs.getInt("invoice_num"));
		orderInfo.setRecipient(rs.getString("recipient"));
		orderInfo.setAddress(rs.getString("address"));
		orderInfo.setDetail_address(rs.getString("detail_address"));
		orderInfo.setPhone_num(rs.getString("phone_num"));
		orderInfo.setRequest(rs.getString("request"));
		orderInfo.setOrder_detail_num(rs.getInt("order_detail_num"));
		orderInfo.setUser_num(rs.getInt("user_num"));
		orderInfo.setImg_name(rs.getString("img_name"));
		
		
		return orderInfo;
	}

	
	
}
