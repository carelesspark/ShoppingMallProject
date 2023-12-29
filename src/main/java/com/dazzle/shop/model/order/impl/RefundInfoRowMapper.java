package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class RefundInfoRowMapper implements RowMapper<OrderVO> {

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		OrderVO orderInfo = new OrderVO();
		orderInfo.setProduct_name(rs.getString("product_name"));
		orderInfo.setOrder_num(rs.getInt("order_num"));
		orderInfo.setSize_name(rs.getString("size_name"));
		orderInfo.setColor_name(rs.getString("color_name"));
		orderInfo.setAmount(rs.getInt("amount"));
		orderInfo.setProduct_state(rs.getString("product_state"));
		orderInfo.setProduct_price(rs.getInt("product_price"));
		orderInfo.setRefund_change_amount(rs.getInt("refund_change_amount"));
		orderInfo.setRefund_change_num(rs.getInt("refund_change_num"));
		orderInfo.setOrder_detail_num(rs.getInt("order_detail_num"));
		orderInfo.setRequest_date(rs.getTimestamp("request_date"));
		orderInfo.setRefund_or_change_reason(rs.getString("refund_or_change_reason"));
		orderInfo.setReason_detail(rs.getString("reason_detail"));
		orderInfo.setBank(rs.getString("bank"));
		orderInfo.setAccount_num(rs.getString("account_num"));
		orderInfo.setCancel(rs.getInt("cancel"));
		orderInfo.setChange(rs.getInt("change"));
		orderInfo.setResponse_detail(rs.getString("response_detail"));
		orderInfo.setApprove(rs.getInt("approve"));
		orderInfo.setRefund_change_amount(rs.getInt("refund_change_amount"));
		orderInfo.setUser_name(rs.getString("user_name"));
		orderInfo.setUser_num(rs.getInt("user_num"));
		orderInfo.setProduct_num(rs.getInt("product_num"));
		orderInfo.setImg_name(rs.getString("img_name"));
		return orderInfo;
	}

}
