package com.dazzle.shop.model.order;

import lombok.Data;

@Data

public class OrderedProductVO {
	private String product_code;
	private String size_name;
	private String color_name;
	private String product_name;
	private String main_img;
	private int total_price;
	private int count;
}
