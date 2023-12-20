package com.dazzle.shop.model.sign.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	private final String CHECK_ID_EXIST = "select user_num from auth_id where id = ?";
	private final String CHECK_EMAIL_EXIST = "select user_num from auth_id where user_email = ?";
	private final String SIGN_UP1 = "INSERT INTO users (user_name) VALUES (?)";
	private final String SIGN_UP2 = "INSERT INTO auth_id (user_num, id, pwd, user_email) VALUES (?,?,?,?)";

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

	////////////////////////// sign up에서 사용

	public boolean checkIdExist(String id) {
		System.out.println("===> SignDAO updatePwd()");

		RowMapper<Boolean> rowMapper = (rs, rowNum) -> {
			int userNum = rs.getInt(1);

			return userNum >= 1;
		};

		try {
			return template.queryForObject(CHECK_ID_EXIST, rowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	public boolean checkEmailExist(String user_email) {
		System.out.println("===> SignDAO updatePwd()");

		RowMapper<Boolean> rowMapper = (rs, rowNum) -> {
			int userNum = rs.getInt(1);

			return userNum >= 1;
		};

		try {
			return template.queryForObject(CHECK_EMAIL_EXIST, rowMapper, user_email);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	public void signUp(SignVO vo) {
		System.out.println("===> SignDAO updatePwd()");

		KeyHolder keyHolder = new GeneratedKeyHolder();

		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SIGN_UP1, Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, vo.getUser_name());

				return pstmt;
			}
		}, keyHolder);
		System.out.println("여기!");
		int userNum = keyHolder.getKey().intValue();
		System.out.println(userNum);
		template.update(SIGN_UP2, userNum, vo.getId(), vo.getPwd(), vo.getUser_email());
		System.out.println("간다!");
	}

}
