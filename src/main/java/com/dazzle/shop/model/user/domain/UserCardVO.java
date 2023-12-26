package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserCardVO {
	// users
	private int user_num;
	private String user_name;
	private String login_type;
	private int is_admin;
	// user_info
	private int user_info_num;
	private String user_phone;
	private String user_rank;
	private Date user_join_date;
	private Date user_update_date;
	private Date user_delete_date;
	private int is_black_list;
	// delivery
	private int delivery_num;
	private Date delivery_date;
	private String delivery_company;
	private int invoice_num;

	// 추가
	private String rank_letter;
	private String delivering_items;
	private int user_total_point;
}
