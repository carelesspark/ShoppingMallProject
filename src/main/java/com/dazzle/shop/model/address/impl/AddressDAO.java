package com.dazzle.shop.model.address.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.address.AddressVO;


@Repository
public class AddressDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	private final String ADDRESS_GET_LIST = "select * from address where user_num = ?";
	private final String ADDRESS_GET = "select * from address where addr_num = ?";
	private final String ADDRESS_UPDATE = "update address set address = ?, detail_address = ?, "
			+ "postal_num = ?, request = ?, base = ?, recipient = ?, phone_num = ? where addr_num = ?";
	private final String BASE_UPDATE = "update address set base = 0 where base = 1 and user_num = ?";
	private final String ADDRESS_DELETE = "delete from address where addr_num = ?";
	private final String ADDRESS_INSERT = "insert into address (user_num, address, detail_address, postal_num, "
			+ " request, base, recipient, phone_num) values(?, ?, ?, ?, ?, ?, ?, ?)";
	
	//주소 목록 조회
	public List<AddressVO> getAddressList(AddressVO vo){
		System.out.println("===> getAddressList() 기능 처리");
		Object[] args = {vo.getUser_num()};
		return jdbcTemplate.query(ADDRESS_GET_LIST,args, new AddressRowMapper());
	}
	
	//주소 조회
		public AddressVO getAddress(AddressVO vo){
			System.out.println("===> getAddress() 기능 처리");
			Object[] args = {vo.getAddr_num()};
			return jdbcTemplate.queryForObject(ADDRESS_GET,args, new AddressRowMapper());
		}
	
	//주소 수정
	public void updateAddress(AddressVO vo) {
		System.out.println("===> updateAddress() 기능 처리");
		if(vo.getBase() == 1) {
			jdbcTemplate.update(BASE_UPDATE, vo.getUser_num());
		}
		jdbcTemplate.update(ADDRESS_UPDATE, vo.getAddress(), vo.getDetail_address(), vo.getPostal_num(),
				vo.getRequest(), vo.getBase(), vo.getRecipient(), vo.getPhone_num(), vo.getAddr_num());
		return;
	}
		
	//주소 삭제
	public void deleteAddress(AddressVO vo) {
		System.out.println("===> deleteAddress() 기능 처리");
		jdbcTemplate.update(ADDRESS_DELETE, vo.getAddr_num());
		return;
	}
	
	//주소 추가
	public void insertAddress(AddressVO vo) {
		System.out.println("===> insertAddress() 기능 처리");
		if(vo.getBase() == 1) {
			jdbcTemplate.update(BASE_UPDATE, vo.getUser_num());
		}
		jdbcTemplate.update(ADDRESS_INSERT, vo.getUser_num(), vo.getAddress(), vo.getDetail_address(),
				vo.getPostal_num(), vo.getRequest(), vo.getBase(), vo.getRecipient(), vo.getPhone_num());
		return;
	}
	
}
