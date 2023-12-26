package com.dazzle.shop.model.order.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.order.OrderVO;

public class ResponseDetailRowMapper implements RowMapper<OrderVO>{

	@Override
	public OrderVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderVO responseDetail = new OrderVO();
		responseDetail.setRefund_change_num(rs.getInt("refund_change_num"));
		responseDetail.setOrder_detail_num(rs.getInt("order_detail_num"));
		responseDetail.setRequest_date(rs.getTimestamp("request_date"));
		responseDetail.setRefund_or_change_reason(rs.getString("refund_or_change_reason"));
		responseDetail.setReason_detail(rs.getString("reason_detail"));
		responseDetail.setRefund_change_amount(rs.getInt("refund_change_amount"));
		responseDetail.setBank(rs.getString("bank"));
		responseDetail.setAccount_num(rs.getString("account_num"));
		responseDetail.setCancel(rs.getInt("cancel"));
		responseDetail.setChange(rs.getInt("change"));
		responseDetail.setResponse_detail(rs.getString("response_detail"));
		responseDetail.setApprove(rs.getInt("approve"));
		
		return responseDetail;
	}

	
	
}
