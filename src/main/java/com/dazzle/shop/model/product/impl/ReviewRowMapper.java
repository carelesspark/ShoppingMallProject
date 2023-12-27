package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.ReviewVO;

public class ReviewRowMapper implements RowMapper<ReviewVO>{

	@Override
	public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ReviewVO vo = new ReviewVO();
		
		vo.setProduct_code(rs.getInt("product_code"));
		vo.setSize_name(rs.getString("size_name"));
		vo.setId(rs.getString("id"));
		vo.setColor_name(rs.getString("color_name"));
		vo.setReview_img(rs.getString("review_img"));
		vo.setReview_date(rs.getDate("review_date"));
		vo.setReview_content(rs.getString("review_content"));
		vo.setReview_ratings(rs.getInt("review_ratings"));
		vo.setReview_num(rs.getInt("review_num"));
		return vo;
	}

	
}
