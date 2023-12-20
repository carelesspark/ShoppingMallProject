package com.dazzle.shop.model.sign.domain;

import lombok.Data;

@Data
public class SignVO {
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
}
