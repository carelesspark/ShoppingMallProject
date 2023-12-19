package com.dazzle.shop.model.sign.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.sign.domain.SignVO;

@Repository("signDAO")
public class SignDAO {

	@Autowired
	private JdbcTemplate template;

	private final String FIND_ID = "select auth_id.id from auth_id "
			+ "join users on auth_id.user_num = users.user_num "
			+ "where users.user_name = ? and auth_id.user_email = ?";
	private final String FIND_PWD = "select count(*) from auth_id where id = ? and user_email = ?";

	private final String SIGN_IN = "SELECT user_num FROM auth_id WHERE id = ? AND pwd = ?";

	// find_id
	public String findId(SignVO vo) {
		System.out.println("===> SignDAO findId()");

		RowMapper<String> rowMapper = (rs, rowNum) -> rs.getString("id");

		try {
			return template.queryForObject(FIND_ID, rowMapper, vo.getUser_name(), vo.getUser_email());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// find_pwd
	public int findPwd(SignVO vo) {
		System.out.println("===> SignDAO findPwd()");

		RowMapper<Integer> rowMapper = (rs, rowNum) -> rs.getInt(1);

		try {
			return template.queryForObject(FIND_PWD, rowMapper, vo.getId(), vo.getUser_email());
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	// sign_in
	public int signIn(SignVO vo) {
		System.out.println("===> SignDAO signIn()");

		RowMapper<Integer> rowMapper = (rs, rowNum) -> rs.getInt("user_num");

		try {
			return template.queryForObject(SIGN_IN, rowMapper, vo.getId(), vo.getPwd());
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

}
