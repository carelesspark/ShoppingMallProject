package com.dazzle.shop.model.cart;

import lombok.Data;

@Data
public class CartVO {
	private int cart_num;
	private int amount;
	private int user_num;
	private int product_code;
	private String main_img;
	private int product_price;
	private int total_price;
	private String product_name;
	private String color_name;
	private String size_name;
	private String img_name;
	private int img_type;
}
