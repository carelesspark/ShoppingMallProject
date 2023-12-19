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
	private final String FIND_PWD = "select user_num from auth_id where id = ? and user_email = ?";
	private final String SIGN_IN = "SELECT user_num FROM auth_id WHERE id = ? AND pwd = ?";
	private final String UPDATE_PWD = "update auth_id set pwd = ? where user_num = ?";

	// find_id
	public SignVO findId(SignVO vo) {
		System.out.println("===> SignDAO findId()");

		RowMapper<SignVO> rowMapper = (rs, rowNum) -> {
			SignVO user = new SignVO();
			user.setId(rs.getString("id"));
			return user;

		};

		try {
			return template.queryForObject(FIND_ID, rowMapper, vo.getUser_name(), vo.getUser_email());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// find_pwd
	public SignVO findPwd(SignVO vo) {
		System.out.println("===> SignDAO findPwd()");

		RowMapper<SignVO> rowMapper = (rs, rowNum) -> {
			SignVO user = new SignVO();
			user.setUser_num(rs.getInt("user_num"));
			return user;

		};

		try {
			return template.queryForObject(FIND_PWD, rowMapper, vo.getId(), vo.getUser_email());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// sign_in
	public SignVO signIn(SignVO vo) {
		System.out.println("===> SignDAO signIn()");

		RowMapper<SignVO> rowMapper = (rs, rowNum) -> {
			SignVO user = new SignVO();
			user.setUser_num(rs.getInt("user_num"));
			return user;
		};

		try {
			return template.queryForObject(SIGN_IN, rowMapper, vo.getId(), vo.getPwd());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// update_pwd
	public void updatePwd(SignVO vo) {
		System.out.println("===> SignDAO updatePwd()");

		template.update(UPDATE_PWD, vo.getPwd(), vo.getUser_num());
	}
}
