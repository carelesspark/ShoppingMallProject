package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.*;

public class UserCardRowMapper implements RowMapper<UserCardVO> {

	@Override
	public UserCardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserCardVO vo = new UserCardVO();
		vo.setRank_letter(rs.getString("rank_letter"));
		vo.setUser_rank(rs.getString("user_rank"));
		vo.setDelivering_items(rs.getString("delivering_items"));

		return vo;
	}

}