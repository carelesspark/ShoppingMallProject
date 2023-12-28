package com.dazzle.shop.model.product;

import lombok.Data;

@Data
public class ProductCartVO {
	private int cart_num;
	private int user_num;
	private int product_code;
	private int amount;
}