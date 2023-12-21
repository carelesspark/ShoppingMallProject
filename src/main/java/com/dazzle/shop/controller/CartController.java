package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

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
	public String getCart(int user_num, CartVO vo, Model model) throws Exception {
		
		
		System.out.println("장바구니 페이지 이동");
		List<CartVO> cartList = new ArrayList();
		cartList = cartService.getCart(user_num);
		
		model.addAttribute("cartList", cartList);
		System.out.println(cartList);
		
		return "/cart/cart.jsp";
	}
	
	@RequestMapping(value="/deleteCart.do")
	public String deleteCart(int cart_num, int user_num, CartVO vo, Model model) throws Exception {
		
		System.out.println(cart_num);
		System.out.println("장바구니 삭제");
		
		cartService.deleteCart(cart_num);
		
		model.addAttribute("user_num", user_num);
		
		return "redirect:cart.do";
	}
	
}
