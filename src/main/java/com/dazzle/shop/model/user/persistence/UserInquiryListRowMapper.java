package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.*;

public class UserInquiryListRowMapper implements RowMapper<UserInquiryVO> {

	@Override
	public UserInquiryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInquiryVO vo = new UserInquiryVO();
		vo.setInquiry_date(rs.getDate("inquiry_date"));
		vo.setAnswer(rs.getString("answer"));
		vo.setInquiry_num(rs.getInt("inquiry_num"));
		vo.setProduct_num(rs.getInt("product_num"));
		vo.setProduct_name(rs.getString("product_name"));
		vo.setColor_name(rs.getString("color_name"));
		vo.setSize_name(rs.getString("size_name"));

		return vo;
	}

}
