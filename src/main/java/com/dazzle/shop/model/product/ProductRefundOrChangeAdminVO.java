package com.dazzle.shop.model.product;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductRefundOrChangeAdminVO {
	private int refund_admin_num;
	private String refund_or_change_reason;
	private String response_detail;
}
