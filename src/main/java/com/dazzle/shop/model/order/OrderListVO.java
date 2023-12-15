package com.dazzle.shop.model.order;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderListVO {
	private int order_num;
	private String product_state;
	private Timestamp delivery_date;
	private String product_name;
	private int product_price;
}
