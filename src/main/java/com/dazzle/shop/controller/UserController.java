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

	// find_id.jsp
	// 아이디 찾기
	@PostMapping("/findId.do")
	public String findId(UserVO vo, Model model) {
		System.out.println("===> UserController: find id");

		String id = userService.findId(vo);

		if (id == null) {
			model.addAttribute("failFindIdMsg", "잘못 기입하셨거나 없는 계정입니다.");
			return "sign/find_id.jsp";
		}

		model.addAttribute("id", id);
		return "sign/found_id.jsp";
	}

	// sign in id
	// 로그인
	@PostMapping("/signInId.do")
	public String signInId(UserVO vo, Model model, HttpSession session) {
		System.out.println("===> UserController: sign in id");

		int userNum = userService.signInId(vo);

		if (userNum == 0) {
			model.addAttribute("failSignIn", "fail");
			return "sign/sign_in.jsp";
		}

		session.setAttribute("user_num", userNum);
		session.setAttribute("savedId", vo.getId());
		return "redirect:/main/main.jsp";
	}

}
