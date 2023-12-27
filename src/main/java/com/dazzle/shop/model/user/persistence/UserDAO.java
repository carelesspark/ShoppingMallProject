package com.dazzle.shop.model.user.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.user.domain.UserVO;

@Repository("userDAO")
public class UserDAO {

	@Autowired
	private JdbcTemplate template;

	private final String getUserInfo = "select * from users inner join user_info on users.user_num = user_info.user_num where user_num = ?";

	public UserVO getUserInfo(UserVO vo) {
		System.out.println("SignDAO getUserInfo");
		
		RowMapper<UserVO> rowMapper = (rs, rowNum) ->{
			UserVO user = new UserVO();
			user.setUser_name(rs.getString("user_num"));
			
			return user;
		};

		return null;
	}
}
