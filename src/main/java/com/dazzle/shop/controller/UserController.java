package com.dazzle.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.user.domain.UserVO;
import com.dazzle.shop.model.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

//	@ModelAttribute("userInfoMap")
//	public Map<String, String> userInfoMap(HttpServletRequest request) {
//		Map<String, String> userInfoMap = new HashMap<String, String>();
//
//		HttpSession session = request.getSession();
//
//		Integer user_num = (Integer) session.getAttribute("user_num");
//		if (user_num == null) {
//			userInfoMap.put("login", "error");
//
//			return userInfoMap;
//		}
//
//		UserVO user = userService.getUserInfo(user_num);
//
//		userInfoMap.put("user_rank", user.getUser_rank());
//
//		return userInfoMap;
//	}

	/*
	 * 주문/배송 조회
	 */
	@RequestMapping("/orderList.do")
	public String userOrderList(HttpServletRequest request, UserVO vo, Model model) {
		System.out.println("UserController: userOrderList");

		HttpSession session = request.getSession();
		// session.getAttribute(name);

		return "/user/user_order_list.jsp";
	}

	/*
	 * 포인트
	 */

	/*
	 * 상품 후기
	 */

	/*
	 * 1:1 문의
	 */
	/*
	 * 작성 글
	 */

	/*
	 * 작성 댓글
	 */

	/*
	 * 회원정보 변경
	 */

	/*
	 * 주소지 관리
	 */

}
