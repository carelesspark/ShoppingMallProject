package com.dazzle.shop.model.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class UserInquiryVO {
	// users
	private int user_num;
	private String user_name;
	private String login_type;
	private int is_admin;
	// inquiry
	private int inquiry_num;
	private String inquiry_content;
	private int public_set;
	private Date inquiry_date;
	// inquiry_answer
	private Date answer_date;
	private String answer;
	// product_code
	private String product_code;
	// product_size
	private int size_num;
	private String size_name;
	private Integer product_stock;
	// product_color
	private int color_num;
	private String color_name;
	// product
	private int product_num;
	private String product_name;
	private String product_info;
	private Date product_date;
	private int product_sell;
	private int product_price;
	private Date modify_date;
	private Date delete_date;
	private int registration_status;
	private int sub_category_num;

	// 1차 추가
	private Date startDate;
	private Date endDate;
	private int currentPage;
	private int itemsPerPage;
}
