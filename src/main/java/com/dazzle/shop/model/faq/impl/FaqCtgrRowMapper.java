package com.dazzle.shop.model.faq.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.faq.*;


public class FaqCtgrRowMapper implements RowMapper<FaqCtgrVO>{

	@Override
	public FaqCtgrVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FaqCtgrVO faqCtgr = new FaqCtgrVO();
		faqCtgr.setCtgr_num(rs.getInt("ctgr_num"));
		faqCtgr.setCtgr_name(rs.getString("ctgr_name"));
		
		return faqCtgr;

	}
	
}
