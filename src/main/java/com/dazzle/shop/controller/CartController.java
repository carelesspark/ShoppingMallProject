package com.dazzle.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.cart.CartService;
import com.dazzle.shop.model.cart.CartVO;



@Controller
@SessionAttributes("cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/cart.do")
	public String getCart(CartVO vo, Model model) throws Exception {
		
		
		return "/cart/cart.jsp";
	}
}
