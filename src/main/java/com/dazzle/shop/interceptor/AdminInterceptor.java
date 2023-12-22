package com.dazzle.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 세션에서 is_admin을 가져옴
		HttpSession session = request.getSession();
		Object user_num = session.getAttribute("user_num");
		Object is_admin = session.getAttribute("is_admin");

		// user_num이 없으면 로그인 페이지로 리다이렉트
		if (user_num == null) {
			response.sendRedirect("/sign/login.jsp");

			return false; // 컨트롤러 메소드 실행을 막음
		}

		// is_admin이 없으면 로그인 페이지로 리다이렉트
		if (is_admin == null) {
			response.sendRedirect("/sign/login.jsp");

			return false;
		}

		// is_admin의 값이 0이면 메인 페이지로 리다이렉트
		if (is_admin.equals("0")) {
			response.sendRedirect("/main/main.jsp");

			return false;
		}

		// 로그인 되어있고, 관리자일 경우에만
		return true; // 컨트롤러 메소드 실행을 허용
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
