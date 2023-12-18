package com.dazzle.shop.model.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	@Autowired
	private JdbcTemplate template;

	private final String USER_SIGN_IN = "SELECT user_num FROM auth_id WHERE id = ? AND pwd = ?";

	// 회원가입

	// 로그인
	public int signInUser(UserVO vo) {
		System.out.println("===> UserDAO signInUser()");

		RowMapper<Integer> rowMapper = (rs, rowNum) -> rs.getInt("user_num");

		try {
			return template.queryForObject(USER_SIGN_IN, rowMapper, vo.getId(), vo.getPwd());
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}

	}

}
