package com.dazzle.shop.model.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.board.FileVO;

public class FileRowMapper implements RowMapper<FileVO> {

	@Override
	public FileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		FileVO vo = new FileVO();
		
		vo.setFno(rs.getInt(1));
		vo.setPno(rs.getInt(2));
		vo.setFname(rs.getString(3));
		vo.setForder(rs.getString(4));
		
		return vo;
	}

}
