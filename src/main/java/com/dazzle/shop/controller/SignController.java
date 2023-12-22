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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazzle.shop.model.sign.domain.SignVO;
import com.dazzle.shop.model.sign.service.SignService;

@Controller
@RequestMapping("/sign")
public class SignController {

	@Autowired
	private SignService signService;

	/*
	 * 바로 접근하는 주소 제공
	 */
	@RequestMapping("/goLogin.do")
	public String goLogin() {
		return "redirect:/sign/login.jsp";
	}

	@RequestMapping("/goFindId.do")
	public String goFindId() {
		return "redirect:/sign/find_id.jsp";
	}

	@RequestMapping("/goFindPwd.do")
	public String goFindPwd() {
		return "redirect:/sign/find_pwd.jsp";
	}

	@RequestMapping("/goRegister.do")
	public String goRegister() {
		return "redirect:/sign/register.jsp";
	}

	/*
	 * 로그인
	 */
	@PostMapping("/login.do")
	public String login(SignVO vo, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SignController: login");

		SignVO user = signService.login(vo); // user_num or null

		if (user == null) { // fail to login
			model.addAttribute("error", "failed");
			return "login.jsp";
		}

		// success to login
		int user_num = user.getUser_num();
		String user_name = user.getUser_name();
		String login_type = user.getLogin_type();
		int is_admin = user.getIs_admin();
		// 서버 session 저장
		// key: "user_num", value: user_num
		request.getSession().setAttribute("user_num", user_num);
		request.getSession().setAttribute("user_name", user_name);
		request.getSession().setAttribute("login_type", login_type);
		request.getSession().setAttribute("is_admin", is_admin);

//		// 사용자 cookie에 "user_num":user_num 저장
//		Cookie userNumCookie = new Cookie("user_num", String.valueOf(user_num));
//		userNumCookie.setMaxAge(7 * 24 * 60 * 60);
//		response.addCookie(userNumCookie);

		// 아이디 저장에 체크되어 있을 경우 cookie에 savedId 저장
		String cbox = request.getParameter("saveId");
		if ("on".equals(cbox)) { // 체크되어 있을 경우
			Cookie savedIdCookie = new Cookie("user_id", vo.getId());
			savedIdCookie.setMaxAge(7 * 24 * 60 * 60);
			response.addCookie(savedIdCookie);
		}

		return "redirect:/main/main.jsp";
	}
	
	/*
	 * 관리자 로그인
	 */
	@PostMapping("/loginAdmin.do")
	public String loginAdmin(SignVO vo, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SignController: loginAdmin");

		SignVO user = signService.loginAdmin(vo); // user_num or null

		if (user == null) { // fail to login
			model.addAttribute("error", "failed");
			return "login_admin.jsp";
		}

		// success to login
		int user_num = user.getUser_num();
		String user_name = user.getUser_name();
		String login_type = user.getLogin_type();
		int is_admin = user.getIs_admin();
		
		if(is_admin == 0) { // 관리자가 아닐 경우
			model.addAttribute("error", "none admin");
			return "login.jsp";
		}
		
		// 서버 session 저장
		// key: "user_num", value: user_num
		request.getSession().setAttribute("user_num", user_num);
		request.getSession().setAttribute("user_name", user_name);
		request.getSession().setAttribute("login_type", login_type);
		request.getSession().setAttribute("is_admin", is_admin);

		return "redirect:/main/main.jsp";
	}

	/*
	 * 아이디 찾기
	 */
	@PostMapping("/findId.do")
	public String findId(SignVO vo, Model model) {
		System.out.println("SignController: findId");

		SignVO user = signService.findId(vo);

		if (user == null) { // fail
			model.addAttribute("error", "failed");
			return "find_id.jsp";
		}

		// success
		model.addAttribute("id", user.getId());
		return "found_id.jsp";
	}

	/*
	 * 비밀번호 재설정 - 첫번째 단계
	 */
	@PostMapping("/findPwd.do")
	public String findPwd(SignVO vo, Model model, HttpSession session) {
		System.out.println("SignController: findPwd");

		SignVO user = signService.findPwd(vo);

		if (user == null) { // fail
			model.addAttribute("error", "failed");
			return "find_pwd.jsp";
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

		return "redirect:/sign/verification_email.jsp";
	}

	/*
	 * 비밀번호 재설정 - 두번째 단계
	 */
	@GetMapping("/verificationEmail.do")
	public String verificationEmail(HttpServletRequest request, Model model) {
		System.out.println("SignController: verificationEmail");

		// 세션에 저장해놓은 인증번호
		HttpSession session = request.getSession();
		String authStrSession = (String) session.getAttribute("tAuthStr");
		// 사용이 끝난 tAuthStr 세션에서 삭제
		session.removeAttribute("tAuthStr");

		// 유저가 전송한 인증번호
		String authStrUser = request.getParameter("authStr");

		if (!authStrSession.equals(authStrUser)) { // fail
			model.addAttribute("error", "failed");
			return "find_pwd.jsp";
		}

		return "redirect:/sign/update_pwd.jsp";
	}

	/*
	 * 비밀번호 재설정 - 세번째 단계
	 */
	@PostMapping("/updatePwd.do")
	public String updatePwd(SignVO vo, HttpSession session) {
		System.out.println("SignController: updatePwd");

		// 세션에 저장해놓은 유저번호
		int user_num = (int) session.getAttribute("tUserNum");
		// 사용이 끝난 tUserNum 세션에서 삭제
		session.removeAttribute("tUserNum");

		vo.setUser_num(user_num);

		signService.updatePwd(vo);

		return "redirect:/sign/login.jsp";
	}

	/*
	 * 회원가입 - 아이디 중복 확인(비동기)
	 */
	@PostMapping("/checkIdDupl.do")
	@ResponseBody
	public ResponseEntity<String> checkIdDupl(@RequestParam String id) {
		System.out.println("SignController: checkIdDupl");

		boolean isIdDupl = signService.isIdDupl(id);

		if (isIdDupl) {
			System.out.println("아이디 중복");
			return ResponseEntity.ok("Duplicate id");
		} else {
			System.out.println("아이디 사용 가능");
			return ResponseEntity.ok("None duplicate id");
		}
	}

	/*
	 * 회원가입 - 이메일 중복 확인(비동기)
	 */
	@PostMapping("/checkEmailDupl.do")
	@ResponseBody
	public ResponseEntity<String> checkEmailDupl(@RequestParam String user_email) {
		System.out.println("SignController: checkEmailDupl");

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

	/*
	 * 회원가입
	 */
	@PostMapping("/register.do")
	public String register(SignVO vo) {
		System.out.println("===> SignController: register");

		signService.register(vo);

		return "redirect:/sign/welcome.jsp";
	}

}
