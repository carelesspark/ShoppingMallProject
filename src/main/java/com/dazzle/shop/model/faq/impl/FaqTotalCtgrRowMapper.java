package com.dazzle.shop.model.faq.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.faq.*;


public class FaqTotalCtgrRowMapper implements RowMapper<FaqVO>{

	@Override
	public FaqVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FaqVO faqTotalCtgrVO = new FaqVO();
		faqTotalCtgrVO.setCtgr_num(rs.getInt("ctgr_num"));
		faqTotalCtgrVO.setSub_ctgr_num(rs.getInt("sub_ctgr_num"));
		faqTotalCtgrVO.setCtgr_name(rs.getString("ctgr_name"));
		faqTotalCtgrVO.setSub_ctgr_name(rs.getString("sub_ctgr_name"));
		return faqTotalCtgrVO;

	}
	
}
