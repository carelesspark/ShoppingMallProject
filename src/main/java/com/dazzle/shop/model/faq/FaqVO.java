package com.dazzle.shop.model.faq;

import java.util.List;

import lombok.Data;

@Data
public class FaqVO {
	private int ctgr_num;
	private String ctgr_name;
	private int sub_ctgr_num;
	private String sub_ctgr_name;
	private int faq_num;
	private String question;
	private String answer;
}
