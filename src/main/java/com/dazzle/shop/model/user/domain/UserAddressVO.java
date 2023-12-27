package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserAddressVO {
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
	// address
	// pk: addr_num
	private int addr_num;
	private String address;
	private String detail_address;
	private String postal_num;
	private String request;
	private boolean base;
	private String recipient;
	private String phone_num;
}
