package com.dazzle.shop.model.cart;

import lombok.Data;

@Data
public class CartVO {
	private int cart_num;
	private int amount;
	private int user_num;
	private String product_code;
}
