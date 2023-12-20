package com.dazzle.shop.model.faq.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.faq.*;


public class FaqRowMapper implements RowMapper<FaqVO>{

	@Override
	public FaqVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FaqVO faq = new FaqVO();
		faq.setFaq_num(rs.getInt("faq_num"));
		faq.setSub_ctgr_num(rs.getInt("sub_ctgr_num"));
		faq.setAnswer(rs.getString("answer"));
		faq.setQuestion(rs.getString("question"));
		
		return faq;

	}
	
}
