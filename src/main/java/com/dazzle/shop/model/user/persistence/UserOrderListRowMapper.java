package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.*;

public class UserOrderListRowMapper implements RowMapper<UserOrdersVO> {

	@Override
	public UserOrdersVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserOrdersVO vo = new UserOrdersVO();

		vo.setOrder_date(rs.getDate("order_date"));
		vo.setDelivery_date(rs.getDate("delivery_date"));
		vo.setProduct_state(rs.getString("product_state"));
		vo.setAmount(rs.getInt("amount"));
		vo.setTotal_price(rs.getInt("total_price"));
		vo.setSize_name(rs.getString("size_name"));
		vo.setColor_name(rs.getString("color_name"));
		vo.setProduct_name(rs.getString("product_name"));
		vo.setOrder_num(rs.getInt("order_num"));
		vo.setOrder_detail_num(rs.getInt("order_detail_num"));
		vo.setProduct_code(rs.getInt("product_code"));

		return vo;
	}

}
