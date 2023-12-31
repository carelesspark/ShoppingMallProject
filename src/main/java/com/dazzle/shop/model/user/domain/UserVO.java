package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserVO {
	// users
	private int user_num;
	private String user_name;
	private String login_type;
	private int is_admin;
	// auth_id
	private int id_num;
	private String id;
	private String pwd;
	private String user_email;
	// auth_kakao
	private int kakao_num;
	private String kakao_email;
	private String refresh_token;
	// user_info
	private int user_info_num;
	private String user_phone;
	private String user_rank;
	private Date user_join_date;
	private Date user_update_date;
	private Date user_delete_date;
	private int is_black_list;

	// 추가
	private String rank_letter;
	private String delivering_items;
}
