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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.order.OrderVO;
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
		UserOrdersVO orderCount = userService.orderCheck(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());
		model.addAttribute("orderCount", orderCount);
		System.out.println(vo.getSearch_order());
		if(vo.getSearch_order() == null) {
			vo.setSearch_order("");
		}
		
		List<UserOrdersVO> list = userService.getUserOrderList(user_num, vo);
		model.addAttribute("orderList", list);
		System.out.println(list);

		return "user_order_list.jsp";
	}
	
	/* 구매 날짜 별 주문 목록 조회 */
	@RequestMapping("/orderListDate.do")
	public String getOrderList2(HttpServletRequest request, @RequestParam(name = "date") Integer date, UserOrdersVO vo, Model model) throws Exception {
		System.out.println("글 목록 검색 처리");
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");
		
		UserVO card = userService.getUserCard(user_num);
		UserOrdersVO orderCount = userService.orderCheck(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());
		model.addAttribute("orderCount", orderCount);
	
		if (date == null) {
			List<UserOrdersVO> orderList = userService.getUserOrderList(user_num, vo.getSearch_order());
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
		} else if (date == 3) {
			List<UserOrdersVO> orderList = userService.getOrderList2(user_num, (int) date);
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
		} else if (date == 6) {
			List<UserOrdersVO> orderList = userService.getOrderList2(user_num, (int) date);
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
		} else if (date == 12) {
			List<UserOrdersVO> orderList = userService.getOrderList2(user_num, (int) date);
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
		}

		return "user_order_list.jsp";
	}

	/*
	 * 포인트
	 */
	@RequestMapping("/pointList.do")
	public String userPointList(HttpServletRequest request, Model model, UserOrdersVO vo) {
		System.out.println("UserController: userPointList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());

//		List<UserOrdersVO> list = userService.getUserOrderList(user_num);
//		model.addAttribute("orderList", list);

		return "user_point_list.jsp";
	}

	/*
	 * 상품 후기
	 */
	@RequestMapping("/reviewList.do")
	public String userReviewList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userReviewList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());

		List<UserReviewVO> list = userService.getUserReviewList(user_num);
		model.addAttribute("reviewList", list);

		return "user_review_list.jsp";
	}

	/*
	 * 1:1 문의
	 */
	@RequestMapping("/inquiryList.do")
	public String userInquiryList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userInquiryList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());

//		List<UserReviewVO> list = userService.getUserReviewList(user_num);
//		model.addAttribute("reviewList", list);

		return "user_inquiry_list.jsp";
	}

	/*
	 * 작성 글
	 */
	@RequestMapping("/boardList.do")
	public String userBoardList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userBoardList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());

//		List<UserReviewVO> list = userService.getUserReviewList(user_num);
//		model.addAttribute("reviewList", list);

		return "user_board_list.jsp";
	}

	/*
	 * 작성 댓글
	 */
	@RequestMapping("/replyList.do")
	public String userReplyList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userReplyList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());

//		List<UserReviewVO> list = userService.getUserReviewList(user_num);
//		model.addAttribute("reviewList", list);

		return "user_reply_list.jsp";
	}

	/*
	 * 회원정보 변경 - 첫번째 단계 - 비밀번호 입력
	 */
	@RequestMapping("/checkInfo.do")
	public String userCheckInfo(HttpServletRequest request, Model model) {
		System.out.println("UserController: userCheckInfo");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());

		return "user_change_info.jsp";
	}

	/*
	 * 회원정보 변경 - 두번째 단계 - 정보 입력 및 수정
	 */
	@RequestMapping("/changeInfo.do")
	public String userChangeInfo(HttpServletRequest request, Model model) {
		System.out.println("UserController: userChangeInfo");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());

		return "user_order_list.jsp";
	}

	/*
	 * 주소지 관리
	 */
	@RequestMapping("/addressList.do")
	public String userAddressList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userAddressList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserVO card = userService.getUserCard(user_num);
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_point", card.getUser_point());

//			List<UserReviewVO> list = userService.getUserReviewList(user_num);
//			model.addAttribute("reviewList", list);

		return "user_address_list.jsp";
	}
}
