package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.UserOrdersVO;

public class UserOrderRowMapper implements RowMapper<UserOrdersVO> {

	@Override
	public UserOrdersVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserOrdersVO userOrdersVO = new UserOrdersVO();
		
		userOrdersVO.setDelivery_date(rs.getDate("delivery_date"));
		userOrdersVO.setOrder_date(rs.getDate("order_date"));
		userOrdersVO.setRecipient(rs.getString("recipient"));
		userOrdersVO.setProduct_state(rs.getString("product_state"));
		userOrdersVO.setAmount(rs.getInt("amount"));
		userOrdersVO.setTotal_price(rs.getInt("total_price"));
		userOrdersVO.setSize_name(rs.getString("size_name"));
		userOrdersVO.setColor_name(rs.getString("color_name"));
		userOrdersVO.setProduct_name(rs.getString("product_name"));
		userOrdersVO.setMain_img(rs.getString("main_img"));
		userOrdersVO.setProduct_price(rs.getInt("product_price"));
		userOrdersVO.setOrder_num(rs.getInt("order_num"));
		userOrdersVO.setProduct_name(rs.getString("product_name"));
		userOrdersVO.setOrder_detail_num(rs.getInt("order_detail_num"));
		return userOrdersVO;
	}

}
