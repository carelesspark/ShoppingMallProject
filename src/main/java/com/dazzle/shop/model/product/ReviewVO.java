package com.dazzle.shop.model.product;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewVO {
	private int review_num;
	private int user_num;
	private int product_num;
	private String review_content;
	private int review_rating;
	private Date review_date;
}
