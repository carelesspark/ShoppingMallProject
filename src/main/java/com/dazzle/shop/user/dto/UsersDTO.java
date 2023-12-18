package com.dazzle.shop.user.dto;

import lombok.Data;

@Data
public class UsersDTO {
	private int user_num;
	private String user_name;
	private String login_type;
	private int is_admin;
}
