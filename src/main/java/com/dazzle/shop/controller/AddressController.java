package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(value = "/addressEdit.do")
	public String getAddress(AddressVO vo, Model model){
		AddressVO address = addressService.getAddress(vo);
		
		model.addAttribute("address", address);
		return "/address/addressEdit.jsp";
	}
	
	@PostMapping(value = "/addressEdit.do")
	public String updateAddress(AddressVO vo, Model model){
		addressService.updateAddress(vo);
		model.addAttribute("user_num", vo.getUser_num());
		return "redirect:address.do";
	}
	
	@RequestMapping(value = "/addressDelete.do")
	public String deleteAddress(AddressVO vo, Model model){
		addressService.deleteAddress(vo);
		model.addAttribute("user_num", vo.getUser_num());
		return "redirect:address.do";
	}
	
	@GetMapping(value = "/addressAdd.do")
	public String addPagination(AddressVO vo, Model model){
		model.addAttribute("user_num", vo.getUser_num());
		return "/address/addressAdd.jsp";
	}
	
	@PostMapping(value = "/addressAdd.do")
	public String insertAddress(AddressVO vo, Model model){
		System.out.println(vo);
		addressService.insertAddress(vo);
		model.addAttribute("user_num", vo.getUser_num());
		return "redirect:address.do";
	}
}
