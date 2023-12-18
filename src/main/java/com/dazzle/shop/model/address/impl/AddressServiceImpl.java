package com.dazzle.shop.model.address.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dazzle.shop.model.address.AddressService;
import com.dazzle.shop.model.address.AddressVO;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
    
    @Autowired
    public AddressDAO addressDAO;

    @Override
    public List<AddressVO> getAddressList(AddressVO vo) {
        return addressDAO.getAddressList(vo);
    }

    @Override
    public void updateAddress(AddressVO vo) {
        addressDAO.updateAddress(vo);
    }

    @Override
    public void deleteAddress(AddressVO vo) {
        addressDAO.deleteAddress(vo);
    }

    @Override
    public void insertAddress(AddressVO vo) {
        addressDAO.insertAddress(vo);
    }

	@Override
	public AddressVO getAddress(AddressVO vo) {
		return addressDAO.getAddress(vo);
	}
}
