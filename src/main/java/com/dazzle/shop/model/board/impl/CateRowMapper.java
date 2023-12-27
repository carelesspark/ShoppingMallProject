package com.dazzle.shop.model.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.board.CateVO;

public class CateRowMapper implements RowMapper<CateVO> {

	@Override
	public CateVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CateVO vo = new CateVO();
		
		vo.setCtgr_num(rs.getInt(1));
		vo.setPno(rs.getInt(2));
		vo.setCtgr_name(rs.getString(3));
		
		return vo;
	}

}
