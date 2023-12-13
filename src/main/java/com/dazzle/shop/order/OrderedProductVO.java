package com.dazzle.shop.order;

import lombok.Data;

@Data

public class OrderedProductVO {
	private int product_id;
	private String product_info;
	private int product_price;
	private int salesVolume;
	private String image;

}
