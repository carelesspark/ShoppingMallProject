package com.dazzle.shop.model.board;

import java.util.List;

import lombok.Data;

@Data
public class FileVO {
	private int fno;
	private int pno;
	private String fname;
	private String forder;
	
	private List<FileVO> fileList;
}
