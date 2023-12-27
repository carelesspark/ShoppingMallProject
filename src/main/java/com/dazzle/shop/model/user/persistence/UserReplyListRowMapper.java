package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.*;

public class UserReplyListRowMapper implements RowMapper<UserReplyVO> {

	@Override
	public UserReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserReplyVO vo = new UserReplyVO();
		vo.setPno(rs.getInt("pno"));
		vo.setTitle(rs.getString("title"));
		vo.setCate(rs.getString("cate"));

		return vo;
	}
}
