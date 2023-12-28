package com.dazzle.shop.model.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.product.InquiryVO;
import com.dazzle.shop.model.product.ProductsVO;

public class InquiryCountRowMapper implements RowMapper<InquiryVO>{

	@Override
	public InquiryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		InquiryVO vo = new InquiryVO();
		
		vo.setTotal_inquiry(rs.getInt("total_inquiry"));
		
		return vo;
	}

	
}
