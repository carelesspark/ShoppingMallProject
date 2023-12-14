package com.dazzle.shop.order;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class OrderVO {
	private int order_num;
	private Timestamp order_date;
	private int delivery_price;
	private String recipient;
	private String postal_num;
	private String address;
	private String detail_address;
	private String phone_num;
	private String request;
	private String payment;
}
