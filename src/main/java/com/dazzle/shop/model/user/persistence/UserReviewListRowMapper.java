package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.*;

public class UserReviewListRowMapper implements RowMapper<UserReviewVO> {

	@Override
	public UserReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserReviewVO vo = new UserReviewVO();
		vo.setReview_date(rs.getDate("review_date"));
		vo.setReview_clicks(rs.getInt("review_clicks"));
		vo.setReview_ratings(rs.getInt("review_ratings"));
		vo.setReview_num(rs.getInt("review_num"));
		vo.setSize_name(rs.getString("size_name"));
		vo.setColor_name(rs.getString("color_name"));
		vo.setProduct_name(rs.getString("product_name"));

		return vo;
	}

}
