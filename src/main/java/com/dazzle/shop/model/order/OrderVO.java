package com.dazzle.shop.model.order;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class OrderVO {
	private int order_num;
	private String product_state;
	private Timestamp delivery_date;
	private String product_name;
	private int product_price;
	private int delivery_num;
	private int invoice_num;
	private String delivery_company;
	private Timestamp order_date;
	private int delivery_price;
	private String recipient;
	private String postal_num;
	private String address;
	private String detail_address;
	private String phone_num;
	private String request;
	private String payment;
	private String color_name;
	private String size_name;
	private int cart_num;
	private int amount;
	private List<Integer> amount_list;
	private int user_num;
	private String product_code;
	private List<String> product_code_list;
	private int user_point;
	private String main_img;
	private int amountMultiPrice;
	private List<Integer> amountMultiPrice_list;
	private int order_detail_num;
	private String refund_or_change_reason;
	private String reason_detail;
	private String bank;
	private String account_num;
	private List<Integer> checkbox;
}
