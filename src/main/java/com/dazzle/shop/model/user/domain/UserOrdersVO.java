package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserOrdersVO {
	// users
	// pk: user_num
	private int user_num;
	private String user_name;
	private String login_type;
	private int is_admin;
	// auth_id
	// pk: id_num
	private int id_num;
	private String id;
	private String pwd;
	private String user_email;
	// auth_kakao
	// pk: kakao_num
	private int kakao_num;
	private String kakao_email;
	private String refresh_token;
	// user_info
	// pk: user_info_num
	private int user_info_num;
	private String user_phone;
	private String user_rank;
	private int user_point;
	private Date user_join_date;
	private Date user_update_date;
	private Date user_delete_date;
	private int is_black_list;
	// orders
	// pk: order_num
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
	// delivery
	// pk: delivery_num
	private int delivery_num;
	private Date delivery_date; // Using java.sql.Date
	private String delivery_company;
	private int invoice_num;
	// order_detail
	// pk: order_detail_num
	private int order_detail_num;
	private String product_state;
	private Integer amount;
	private int total_price;
	// product_code
	// pk: product_code
	private String product_code;
	// product_size
	// pk: size_num
	private int size_num;
	private String size_name;
	private Integer product_stock;
	private String size_code;
	// product_color
	// pk: color_num
	private int color_num;
	private String color_name;
	private String color_code;
	// product
	// pk: product_num
	private int product_num;
	private String product_name;
	private String product_info;
	private Date product_date;
	private int product_sell;
	private int product_price;
	private Date modify_date;
	private Date delete_date;
	private int registration_status;
	private String product_class_code;
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
}
