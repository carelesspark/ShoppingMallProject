package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserBoardVO {
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
	// board
	private int pno;
	private String title;
	private String cate;
	private Date posttime;
	private String content;
	// reply
	private int rno;
	private String rcontent;

	// 1차 추가
	private Date startDate;
	private Date endDate;
	private int currentPage;
	private int itemsPerPage;

	// 2차 추가
	private int reply_count;
}
