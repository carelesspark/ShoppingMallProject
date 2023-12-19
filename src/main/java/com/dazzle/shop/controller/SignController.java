package com.dazzle.shop.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dazzle.shop.model.sign.domain.SignVO;
import com.dazzle.shop.model.sign.service.SignService;

@Controller
@SessionAttributes("sign")
public class SignController {

	@Autowired
	private SignService signService;

	// check_email
	@GetMapping("/checkEmailPwd.do")
	public String checkEmailPwd(Model model, HttpServletRequest request) {
		System.out.println("===> SignController: check email auth - pwd");

		if (!signService.checkEmailPwd(request)) { // fail
			model.addAttribute("failFindPwd", "fail");
			return "sign/find_pwd.jsp";
		}

		return "redirect:/sign/update_pwd.jsp";
	}

	// find_id
	// 아이디 찾기 기능
	@PostMapping("/findId.do")
	public String findId(SignVO vo, Model model) {
		System.out.println("===> SignController: find id");

		String id = signService.findId(vo);

		if (id == null) { // fail
			model.addAttribute("failFindId", "fail");
			return "sign/find_id.jsp";
		}

		model.addAttribute("id", id);
		return "sign/found_id.jsp";
	}

	// find_pwd
	// 비밀번호 찾기 기능 - 첫번째 단계
	@PostMapping("/findPwd.do")
	public String findPwd(SignVO vo, Model model, HttpSession session) {
		System.out.println("===> SignController: find pwd");

		int cnt = signService.findPwd(vo);

		if (cnt == 0) { // fail
			model.addAttribute("failFindPwd", "fail");
			return "sign/find_pwd.jsp";
		}

		// uuid 생성 및 앞 6자리 session에 저장
		UUID uuid4 = UUID.randomUUID();
		String authStr = uuid4.toString().substring(0, 6); // 6자리 문자열 생성
		session.setAttribute("authStr", authStr);

		// 이메일로 uuid 전송
		signService.sendEmail(vo.getUser_email(), authStr);

		return "redirect:/sign/check_email_pwd.jsp";
	}

	// sign_in
	// 로그인 기능
	@PostMapping("/signIn.do")
	public String signId(SignVO vo, Model model, HttpSession session) {
		System.out.println("===> SignController: sign in");

		int user_num = signService.signIn(vo);

		if (user_num == 0) { // fail to sign in
			model.addAttribute("failSignIn", "fail");
			return "sign/sign_in.jsp";
		}

		// success to sign in
		// save user_num in session
		// save id for quick sign in
		session.setAttribute("user_num", user_num);
		session.setAttribute("savedId", vo.getId());
		return "redirect:/main/main.jsp";
	}
}
