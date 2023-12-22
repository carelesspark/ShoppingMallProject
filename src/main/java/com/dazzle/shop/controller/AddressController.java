package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String getAddressList(HttpServletRequest request, Model model){
		AddressVO vo = new AddressVO();
		HttpSession session = request.getSession();
	    vo.setUser_num((int)session.getAttribute("user_num"));
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
	public String updateAddress(HttpServletRequest request, AddressVO vo, Model model){
		HttpSession session = request.getSession();
	    vo.setUser_num((int)session.getAttribute("user_num"));
		addressService.updateAddress(vo);
		model.addAttribute("user_num", vo.getUser_num());
		return "redirect:address.do";
	}
	
	@RequestMapping(value = "/addressDelete.do")
	public String deleteAddress(HttpServletRequest request, AddressVO vo, Model model){
		addressService.deleteAddress(vo);
		HttpSession session = request.getSession();
	    int user_num = (int)session.getAttribute("user_num");
		model.addAttribute("user_num", user_num);
		return "redirect:address.do";
	}
	
	@GetMapping(value = "/addressAdd.do")
	public String addPagination(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
	    int user_num = (int)session.getAttribute("user_num");
		model.addAttribute("user_num", user_num);
		return "/address/addressAdd.jsp";
	}
	
	@PostMapping(value = "/addressAdd.do")
	public String insertAddress(HttpServletRequest request, AddressVO vo, Model model){
		HttpSession session = request.getSession();
	    vo.setUser_num((int)session.getAttribute("user_num"));
		addressService.insertAddress(vo);
		model.addAttribute("user_num", vo.getUser_num());
		return "redirect:address.do";
	}
}
