package com.dazzle.shop.model.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int pno;
	private int userNum;
	private int ctgr_num;
	private String title;
	private String cate;
	private Date posttime;
	private String content;
	
	private String user_name;
	private String ctgr_name;
}
