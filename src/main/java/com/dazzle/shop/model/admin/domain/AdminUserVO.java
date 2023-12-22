package com.dazzle.shop.model.admin.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class AdminUserVO {

	// users
	// pk: user_num
	private int user_num;
	private String user_name;
	private String login_type;
	private int is_admin;
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
	
	// 추가
	private int list_num;
	private int page_num;
}
