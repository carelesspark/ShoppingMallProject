package com.dazzle.shop.model.faq.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.faq.*;


public class FaqSubCtgrRowMapper implements RowMapper<FaqVO>{

	@Override
	public FaqVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FaqVO faqSubCtgr = new FaqVO();
		faqSubCtgr.setCtgr_num(rs.getInt("ctgr_num"));
		faqSubCtgr.setSub_ctgr_num(rs.getInt("sub_ctgr_num"));
		faqSubCtgr.setSub_ctgr_name(rs.getString("sub_ctgr_name"));
		return faqSubCtgr;

	}
	
}
