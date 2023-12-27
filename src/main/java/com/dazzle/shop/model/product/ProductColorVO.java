package com.dazzle.shop.model.product;

import java.util.List;

import lombok.Data;

@Data
public class ProductColorVO {
	
	private int color_num;
	private String color_name;
	private int product_num;
	private List<ProductSizeVO> sizes;
}
