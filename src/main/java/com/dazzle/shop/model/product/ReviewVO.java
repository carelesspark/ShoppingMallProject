package com.dazzle.shop.model.product;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReviewVO {
	private int review_num;
	private int product_code;
	private String color_name;
	private String size_name;
	private String id;
	private String review_img;
	private String review_content;
	private int review_ratings;
	private Date review_date;
	private int product_num;
	private int count;
	private int user_num;
	private MultipartFile real_img;
}
