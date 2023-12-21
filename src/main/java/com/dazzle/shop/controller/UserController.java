package com.dazzle.shop.controller;

import java.util.HashMap;
import java.util.List;
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

import com.dazzle.shop.model.user.domain.UserOrdersVO;
import com.dazzle.shop.model.user.domain.UserReviewVO;
import com.dazzle.shop.model.user.domain.UserVO;
import com.dazzle.shop.model.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * 주문/배송 조회
	 */
	@RequestMapping("/orderList.do")
	public String userOrderList(HttpServletRequest request, Model model, UserOrdersVO vo) {
		System.out.println("UserController: userOrderList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		List<UserOrdersVO> list = userService.getUserOrderList(user_num);

		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());
		model.addAttribute("orderList", list);

		return "user_order_list.jsp";
	}

	/*
	 * 포인트
	 */

	/*
	 * 상품 후기
	 */
	@RequestMapping("/reviewList.do")
	public String userReviewList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userReviewList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		List<UserReviewVO> list = userService.getUserReviewList(user_num);

		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());
		model.addAttribute("reviewList", list);

		return "user_review_list.jsp";
	}

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
