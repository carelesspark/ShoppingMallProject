package com.dazzle.shop.model.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	@Autowired
	private JdbcTemplate template;
	
	private final String USER_SIGN_IN = "select user_num from auth_id where id = ?, pwd = ?";
	
	// 회원가입
	
	
	// 로그인
	public UserVO signInUser(UserVO vo) {
		System.out.println("===> UserDAO signInUser()");
		
		RowMapper<UserVO> rowMapper = (rs, rowNum) -> {
			UserVO user = new UserVO();
			user.setUser_num(rs.getInt("user_num"));
			
			return user;
		};
		
		return template.queryForObject(USER_SIGN_IN, rowMapper, vo.getId(), vo.getPwd());
	}
	
	
}
