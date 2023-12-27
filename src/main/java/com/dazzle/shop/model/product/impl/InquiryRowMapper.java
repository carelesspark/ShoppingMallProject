package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.InquiryVO;
import com.dazzle.shop.model.product.ProductsVO;

public class InquiryRowMapper implements RowMapper<InquiryVO>{

	@Override
	public InquiryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		InquiryVO vo = new InquiryVO();
		
		vo.setInquiry_num(rs.getInt("inquiry_num"));
		vo.setUser_num(rs.getInt("user_num"));
		vo.setProduct_num(rs.getInt("product_num"));
		vo.setInquiry_date(rs.getTimestamp("inquiry_date"));
		vo.setInquiry_title(rs.getString("inquiry_title"));
		vo.setInquiry_content(rs.getString("inquiry_content"));
		
		return vo;
	}

	
}
