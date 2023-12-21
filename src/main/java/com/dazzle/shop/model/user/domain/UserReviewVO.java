package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserReviewVO {
	// users
	// pk: user_num
	private int user_num;
	private String user_name;
	private String login_type;
	private int is_admin;
	// user_info
	// pk: id_num
	private int user_info_num;
	private String user_phone;
	private String user_rank;
	private int user_point;
	private Date user_join_date;
	private Date user_update_date;
	private Date user_delete_date;
	private int is_black_list;
	// review
	// pk: review_num
	private int review_num;
	private String review_content;
	private int review_ratings;
	private Date review_date;
	private int review_clicks;
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
}
