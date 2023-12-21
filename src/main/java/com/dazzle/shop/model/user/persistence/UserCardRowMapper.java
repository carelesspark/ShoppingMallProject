package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.UserVO;

public class UserCardRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		
		user.setUser_rank(rs.getString("user_rank"));
		user.setUser_point(rs.getInt("user_point"));

		return user;
	}

}
