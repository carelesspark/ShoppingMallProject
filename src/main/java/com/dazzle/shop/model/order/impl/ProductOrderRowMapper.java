package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class ProductOrderRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO productOrderList = new OrderVO();
		productOrderList.setProduct_code(rs.getInt("product_code"));
		productOrderList.setImg_name(rs.getString("img_name"));
		productOrderList.setAmountMultiPrice(rs.getInt("total_price"));
		productOrderList.setAmount(rs.getInt("amount"));
		productOrderList.setProduct_name(rs.getString("product_name"));
		productOrderList.setColor_name(rs.getString("color_name"));
		productOrderList.setSize_name(rs.getString("size_name"));
		productOrderList.setProduct_num(rs.getInt("product_num"));
		
		
		return productOrderList;
	}

	
	
}
