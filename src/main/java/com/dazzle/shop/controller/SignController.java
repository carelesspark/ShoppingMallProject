package com.dazzle.shop.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.sign.domain.SignVO;
import com.dazzle.shop.model.sign.service.SignService;

@Controller
@SessionAttributes("sign")
public class SignController {

	@Autowired
	private SignService signService;

	// check_email
	// 비밀번호 재설정 기능 - 두번째 단계
	@GetMapping("/checkEmailPwd.do")
	public String checkEmailPwd(Model model, HttpServletRequest request) {
		System.out.println("===> SignController: check email auth - pwd");

		// 세션에 저장해놓은 인증번호
		HttpSession session = request.getSession();
		String authStrSession = (String) session.getAttribute("tAuthStr");
		// 사용이 끝난 tAuthStr 세션에서 삭제
		session.removeAttribute("tAuthStr");

		// 유저가 전송한 인증번호
		String authStrUser = request.getParameter("authStr");

		if (!authStrSession.equals(authStrUser)) { // fail
			model.addAttribute("error", "failed");
			return "sign/find_pwd.jsp";
		}

		return "redirect:/sign/update_pwd.jsp";
	}

	// find_id
	// 아이디 찾기 기능
	@PostMapping("/findId.do")
	public String findId(SignVO vo, Model model) {
		System.out.println("===> SignController: find id");

		SignVO user = signService.findId(vo);

		if (user == null) { // fail
			model.addAttribute("error", "failed");
			return "sign/find_id.jsp";
		}

		// success
		model.addAttribute("id", user.getId());
		return "sign/found_id.jsp";
	}

	// find_pwd
	// 비밀번호 재설정 기능 - 첫번째 단계
	@PostMapping("/findPwd.do")
	public String findPwd(SignVO vo, Model model, HttpSession session) {
		System.out.println("===> SignController: find pwd");

		SignVO user = signService.findPwd(vo);

		if (user == null) { // fail
			model.addAttribute("error", "failed");
			return "sign/find_pwd.jsp";
		}

		// success
		// user_num 저장 및 후에 비밀번호 재설정 때 사용
		session.setAttribute("tUserNum", user.getUser_num());

		// uuid 생성 및 앞 6자리 session에 저장 및 인증번호 확인 때 사용
		UUID uuid4 = UUID.randomUUID();
		String authStr = uuid4.toString().substring(0, 6); // 6자리 문자열 생성
		session.setAttribute("tAuthStr", authStr);

		// 이메일로 uuid 전송
		signService.sendEmail(vo.getUser_email(), authStr);

		return "redirect:/sign/check_email_pwd.jsp";
	}

	// sign_in
	// 로그인 기능
	@PostMapping("/signIn.do")
	public String signId(SignVO vo, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("===> SignController: sign in");

		SignVO user = signService.signIn(vo); // user_num or null

		if (user == null) { // fail to sign in
			model.addAttribute("error", "failed");
			return "sign/sign_in.jsp";
		}

		// success to sign in
		int user_num = user.getUser_num();
		// 서버 session에 user_num 저장
		request.getSession().setAttribute("user_num", String.valueOf(user_num));
		// 사용자 cookie에 user_num 저장
		Cookie userNumCookie = new Cookie("user_num", String.valueOf(user_num));
		userNumCookie.setMaxAge(7 * 24 * 60 * 60);
		response.addCookie(userNumCookie);

		// 아이디 저장에 체크되어 있을 경우 cookie에 savedId 저장
		String cbox = request.getParameter("saveId");
		if ("on".equals(cbox)) { // 체크되어 있을 경우
			Cookie savedIdCookie = new Cookie("savedId", vo.getId());
			savedIdCookie.setMaxAge(7 * 24 * 60 * 60);
			response.addCookie(savedIdCookie);
		}

		return "redirect:/main/main.jsp";
	}

	// update_pwd
	// 비밀번호 재설정 기능
	@PostMapping("/updatePwd.do")
	public String updatePwd(SignVO vo, HttpSession session) {
		System.out.println("===> SignController: update pwd");

		// 세션에 저장해놓은 유저번호
		int user_num = (int) session.getAttribute("tUserNum");
		// 사용이 끝난 tUserNum 세션에서 삭제
		session.removeAttribute("tUserNum");

		vo.setUser_num(user_num);

		signService.updatePwd(vo);

		return "redirect:/sign/sign_in.jsp";
	}

	/////////////////
	// sign_up id 중복 체크
	@PostMapping("/checkIdSignUp.do")
	@ResponseBody
	public ResponseEntity<String> checkIdSignUp(@RequestParam String id) {
		System.out.println("===> SignController: check id dupl - sign up");

		boolean isIdDupl = signService.isIdDupl(id);

		if (isIdDupl) {
			System.out.println("아이디 중복");
			return ResponseEntity.ok("Duplicate id");
		} else {
			System.out.println("아이디 사용 가능");
			return ResponseEntity.ok("None duplicate id");
		}
	}

	@PostMapping("/checkEmailSignUp.do")
	@ResponseBody
	public ResponseEntity<String> checkEmailSignUp(@RequestParam String user_email) {
		System.out.println("===> SignController: check email dupl - sign up");

		if (user_email == "") {
			return ResponseEntity.ok("Empty input");
		}

		boolean isEmailDupl = signService.isEmailDupl(user_email);

		if (isEmailDupl) {
			System.out.println("이메일 중복");
			return ResponseEntity.ok("Duplicate email");
		} else {
			System.out.println("이메일 사용 가능");
			return ResponseEntity.ok("None duplicate email");
		}
	}
	
	@PostMapping("/signUp.do")
	public String signUp(SignVO vo) {
		System.out.println("===> SignController: sign up");

		signService.signUp(vo);

		return "redirect:/sign/success_sign_up.jsp";
	}


}
