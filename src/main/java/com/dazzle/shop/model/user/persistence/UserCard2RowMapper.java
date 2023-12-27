package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.*;

public class UserCard2RowMapper implements RowMapper<UserCardVO> {

	@Override
	public UserCardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserCardVO vo = new UserCardVO();
		vo.setUser_total_point(rs.getInt("user_total_point"));

		return vo;
	}

}