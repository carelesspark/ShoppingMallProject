package com.dazzle.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.user.UserVO;
import com.dazzle.shop.model.user.impl.UserServiceImpl;

@Controller
@SessionAttributes("user") // session 영역에 user 저장
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	// 회원가입, 로그인 ...

	// 로그인
	@PostMapping("/signInId.do")
	public String signInId(UserVO vo, Model model, HttpSession session) {
		System.out.println("===> UserController: sign in id");

		int userNum = userService.signInUser(vo);

		if (userNum == 0) {
			return "sign/sign_in.jsp";
		} else {
			model.addAttribute("user_num", userNum);
			session.setAttribute("savedId", vo.getId());
			return "redirect:/user/user_order_tracking.jsp";
		}
	}

}
