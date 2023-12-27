package com.dazzle.shop.model.product;

import lombok.Data;

@Data
public class PageVO {
	private int page;
	private int max_page;
	private int start_page;
	private int end_page;
}
