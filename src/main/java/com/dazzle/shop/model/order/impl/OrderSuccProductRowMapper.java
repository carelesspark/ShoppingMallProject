package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class OrderSuccProductRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderVO orderInfo = new OrderVO();
		orderInfo.setImg_name(rs.getString("img_name"));
		orderInfo.setProduct_code(rs.getInt("product_code"));
		orderInfo.setProduct_num(rs.getInt("product_num"));
		orderInfo.setSize_name(rs.getString("size_name"));
		orderInfo.setColor_name(rs.getString("color_name"));
		orderInfo.setProduct_price(rs.getInt("product_price"));
		orderInfo.setProduct_name(rs.getString("product_name"));
		orderInfo.setAmount(rs.getInt("amount"));
		orderInfo.setAmountMultiPrice(rs.getInt("total_price"));
		
		return orderInfo;
	}

	
	
}
