package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserCartVO {
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
	// pk: id_num
	private int kakao_num;
	private String kakao_email;
	private String refresh_token;
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
	// cart
	// pk: cart_num
	private int cart_num;
	private int amount; // Use Integer to represent nullable INT in the database
	private String product_code;
}
