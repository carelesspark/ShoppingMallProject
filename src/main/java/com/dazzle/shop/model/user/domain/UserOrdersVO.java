package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserOrdersVO {
	// users
	private int user_num;
	private String user_name;
	private String login_type;
	private int is_admin;
	// user_info
	private int user_info_num;
	private String user_phone;
	private String user_rank;
	private int user_point;
	private Date user_join_date;
	private Date user_update_date;
	private Date user_delete_date;
	private int is_black_list;
	// orders
	private int order_num;
	private Date order_date;
	private String address;
	private String detail_address;
	private String postal_num;
	private int delivery_price;
	private String recipient;
	private String request;
	private String payment;
	private String phone_num;
	private int order_type;
	// delivery
	private int delivery_num;
	private Date delivery_date;
	private String delivery_company;
	private int invoice_num;
	// order_detail
	private int order_detail_num;
	private String product_state;
	private int amount;
	private int total_price;
	// product_code
	private String product_code;
	// product_size
	private int size_num;
	private String size_name;
	private Integer product_stock;
	// product_color
	private int color_num;
	private String color_name;
	// product
	private int product_num;
	private String product_name;
	private String product_info;
	private Date product_date;
	private int product_sell;
	private int product_price;
	private Date modify_date;
	private Date delete_date;
	private int registration_status;
	private int sub_category_num;

	// 수정
	private String main_img;
	private int total_orders;
	private int orders_in_preparation;
	private int orders_in_delivery;
	private int orders_delivered;
	private String search_order;

	// product_refund_or_change
	private int refund_change_num;
	private Date request_date;
	private String refund_or_change_reason;
	private String reason_detail;
	private int proc_amount;
	private String bank;
	private String account_num;
	private int cancel;
	private int change;

	// 1차 추가
	private int itemsPerPage;
	private int currentPage;
	private Date startDate;
	private Date endDate;

	// 2차 추가

}
