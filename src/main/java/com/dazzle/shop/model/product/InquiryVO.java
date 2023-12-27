package com.dazzle.shop.model.product;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class InquiryVO {
	public int inquiry_num;
	public int user_num;
	public int product_num;
	public String inquiry_content;
	public String inquiry_title;
	public Timestamp inquiry_date;
	public int total_inquiry;
}
