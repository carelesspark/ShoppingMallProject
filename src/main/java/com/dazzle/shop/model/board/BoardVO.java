package com.dazzle.shop.model.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int pno;
	private int userNum;
	private String title;
	private String cate;
	private Date posttime;
	private String content;
}
