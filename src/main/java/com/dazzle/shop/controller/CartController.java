package com.dazzle.shop.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.cart.CartService;
import com.dazzle.shop.model.cart.CartVO;

@Controller
@SessionAttributes("cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/cart.do")
	public String getCart(HttpServletRequest req, CartVO vo, Model model) throws Exception {

		if (req.getSession().getAttribute("user_num") == null) {
			return "/sign/login.jsp";
		}

		int user_num = (int) req.getSession().getAttribute("user_num");

		System.out.println("장바구니 페이지 이동");
		List<CartVO> cartList = new ArrayList();
		cartList = cartService.getCart(user_num);

		model.addAttribute("cartList", cartList);
		System.out.println(cartList);

		return "/cart/cart.jsp";
	}

	@RequestMapping(value = "/deleteCart.do")
	public String deleteCart(int cart_num, int user_num, HttpServletResponse response, CartVO vo, Model model)
			throws Exception {

		System.out.println(cart_num);
		System.out.println("장바구니 삭제");

		cartService.deleteCart(cart_num);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('삭제되었습니다');</script>");

		model.addAttribute("user_num", user_num);

		return "redirect:cart.do";
	}

	@RequestMapping(value = "/deleteCartAll.do")
	public String deleteCart(int user_num, HttpServletResponse response, CartVO vo, Model model) throws Exception {

		System.out.println(user_num);
		System.out.println("장바구니 전체 삭제");

		cartService.deleteCartAll(user_num);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('모든 장바구니 내역이 삭제되었습니다');</script>");

		model.addAttribute("user_num", user_num);

		return "redirect:cart.do";
	}

}
