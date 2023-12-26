package com.dazzle.shop.model.admin.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class AdminProductVO {

	// product_code
	private int product_code;
	// product_size
	private int size_num;
	private String size_name;
	private int product_stock;
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
	// product_img
	private int img_num;
	private String main_img;
	private String sub_img;
	// sub_category
	private int sub_category_num;
	private String sub_category_name;
	// category
	private int category_num;
	private String category_name;

	// 추가
	private int list_num;
	private int page_num;
	private int total_stock;

}
