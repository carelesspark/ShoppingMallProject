package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dazzle.shop.model.address.AddressService;
import com.dazzle.shop.model.address.AddressVO;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value="/address.do")
	public String getAddressList(AddressVO vo, Model model){
		List<AddressVO> addressList = addressService.getAddressList(vo);
		
		model.addAttribute("addressList", addressList);
		return "/address/address.jsp";
	}
}
