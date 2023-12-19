package com.dazzle.shop.model.address;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface AddressService {
	//주소 목록 조회
	List<AddressVO> getAddressList(AddressVO vo);
	
	//주소 수정
	void updateAddress(AddressVO vo);
	
	//주소 삭제
	void deleteAddress(AddressVO vo);
		
	//주소 추가
	void insertAddress(AddressVO vo);
		
}
