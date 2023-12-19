package com.dazzle.shop.model.address.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.address.AddressVO;


public class AddressRowMapper implements RowMapper<AddressVO>{

	@Override
	public AddressVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AddressVO address = new AddressVO();
		address.setAddr_num(rs.getInt("addr_num"));
		address.setUser_num(rs.getInt("user_num"));
		address.setAddress(rs.getString("address"));
		address.setDetail_address(rs.getString("detail_address"));
		address.setPostal_num(rs.getString("postal_num"));
		address.setRequest(rs.getString("request"));
		address.setBase(rs.getInt("base"));
		address.setRecipient(rs.getString("recipient"));
		address.setPhone_num(rs.getString("phone_num"));
		
		return address;

	}
	
}
