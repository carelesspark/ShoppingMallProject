package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserPointVO {
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
	// point
	private int point_num;
	private int points;
	private int point_type;
	// order_detail
	private int order_detail_num;
	private String product_state;
	private int amount;
	private int total_price;
	private int is_canceled;
	private int is_changed;
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
	private Date arrival_date;
	private int order_type;
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

	// 1차 추가
	private Date startDate;
	private Date endDate;
	private int currentPage;
	private int itemsPerPage;

}
