package com.dazzle.shop.model.faq;

import java.util.List;

import lombok.Data;

@Data
public class FaqVO {
	private int faq_num;
	private String question;
	private String answer;
	private int sub_ctgr_num;

}
