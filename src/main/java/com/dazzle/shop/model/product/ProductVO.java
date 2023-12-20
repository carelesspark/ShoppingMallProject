package com.dazzle.shop.model.product;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductVO {
	
	private int product_num;
	private String product_name;
	private	String product_info;
	private Date product_date;
	private int product_sell;
	private int product_price;
	private Date modify_date;
	private Date delete_date;
	private int registration_status;
	private String product_class_code;
	private int sub_category_num;
	
}
