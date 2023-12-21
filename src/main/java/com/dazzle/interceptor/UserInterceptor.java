package com.dazzle.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dazzle.shop.model.user.domain.UserVO;
import com.dazzle.shop.model.user.persistence.UserDAO;

public class UserInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션에서 user_num을 가져옴
		HttpSession session = request.getSession();
		Object user_num = session.getAttribute("user_num");

		// user_num이 없으면 로그인 페이지로 리다이렉트
		if (user_num == null) {
			response.sendRedirect("/sign/login.jsp");

			return false; // 컨트롤러 메소드 실행을 막음
		}

		// user_num 존재시, db에서 user_num으로 users와 user_info 내 data 가져옴
		UserVO vo = new UserVO();
		vo.setUser_num((int) user_num);
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUserInfo(vo);

		Object user_name = session.getAttribute("user_name");
		if (user_name == null) {
			session.setAttribute("user_name", "");
		}

		return true; // 컨트롤러 메소드 실행을 허용
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
