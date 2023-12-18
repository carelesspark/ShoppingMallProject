package com.dazzle.shop.model.order;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductRefundOrChangeVO {
	private int refund_change_num;
	private int amount;
	private Timestamp request_date;
	private String request_state;
	private String refund_or_change_reason;
	private String reason_detail;
	
}
