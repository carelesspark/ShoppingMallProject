package com.dazzle.shop.model.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.board.ReplyVO;

public class ReplyRowMapper implements RowMapper<ReplyVO> {

	@Override
	public ReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ReplyVO vo = new ReplyVO();

		vo.setRno(rs.getInt(1));
		vo.setPno(rs.getInt(2));
		vo.setUserNum(rs.getInt(3));
		vo.setRcontent(rs.getString(4));
		vo.setUser_name(rs.getString("user_name"));

		return vo;
	}

}
