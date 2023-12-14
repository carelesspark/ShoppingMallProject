package com.dazzle.shop.user.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class UserInfoDTO {
	private int user_info_num;
	private int user_num;
	private String user_phone;
	private String user_email;
	private String user_rank;
	private int user_point;
	private Date user_join_date;
	private Date user_update_date;
	private Date user_delete_date;
	private int is_black_list;
}
