package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.*;

public class UserBoardListRowMapper implements RowMapper<UserBoardVO> {

	@Override
	public UserBoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBoardVO vo = new UserBoardVO();
		vo.setPno(rs.getInt("pno"));
		vo.setTitle(rs.getString("title"));
		vo.setCate(rs.getString("cate"));
		vo.setPosttime(rs.getDate("posttime"));
		vo.setReply_count(rs.getInt("reply_count"));

		return vo;
	}

}
