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

	private final String FIND_ID = "SELECT auth_id.id FROM auth_id "
			+ "JOIN users ON auth_id.user_num = users.user_num "
			+ "JOIN user_info ON auth_id.user_num = user_info.user_num "
			+ "WHERE users.user_name = ? AND user_info.user_email = ?";
	private final String SIGN_IN_ID = "SELECT user_num FROM auth_id WHERE id = ? AND pwd = ?";

	// find id
	public String findId(UserVO vo) {
		System.out.println("===> UserDAO findId()");

		RowMapper<String> rowMapper = (rs, rowNum) -> rs.getString("id");

		try {
			return template.queryForObject(FIND_ID, rowMapper, vo.getUser_name(), vo.getUser_email());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// sign in
	public int signInId(UserVO vo) {
		System.out.println("===> UserDAO signInUser()");

		RowMapper<Integer> rowMapper = (rs, rowNum) -> rs.getInt("user_num");

		try {
			return template.queryForObject(SIGN_IN_ID, rowMapper, vo.getId(), vo.getPwd());
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

}
