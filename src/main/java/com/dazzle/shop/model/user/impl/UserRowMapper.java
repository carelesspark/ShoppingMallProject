package com.dazzle.shop.model.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.UserVO;

public class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserVO vo = new UserVO();

		// users
		vo.setUser_num(rs.getInt("user_num"));
		vo.setUser_name(rs.getString("user_name"));
		vo.setLogin_type(rs.getString("login_type"));
		vo.setIs_admin(rs.getInt("is_admin"));
		// auth_id
		vo.setId_num(rs.getInt("id_num"));
		vo.setId(rs.getString("id"));
		vo.setPwd(rs.getString("pwd"));
		// auth_kakao
		vo.setKakao_num(rs.getInt("kakao_num"));
		vo.setKakao_email(rs.getString("kakao_email"));
		vo.setRefresh_token(rs.getString("refresh_token"));
		// user_info
		vo.setUser_info_num(rs.getInt("user_info_num"));
		vo.setUser_phone(rs.getString("user_phone"));
		vo.setUser_email(rs.getString("user_email"));
		vo.setUser_rank(rs.getString("user_rank"));
		vo.setUser_point(rs.getInt("user_point"));
		vo.setUser_join_date(rs.getDate("user_join_date"));
		vo.setUser_update_date(rs.getDate("user_update_date"));
		vo.setUser_delete_date(rs.getDate("user_delete_date"));
		vo.setIs_black_list(rs.getInt("is_black_list"));

		return vo;
	}

}
