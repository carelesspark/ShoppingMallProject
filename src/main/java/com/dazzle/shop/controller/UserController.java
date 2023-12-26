package com.dazzle.shop.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

import com.dazzle.shop.model.user.domain.*;
import com.dazzle.shop.model.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 나의 쇼핑
	// 주문/배송 조회
	@RequestMapping("/orderList.do")
	public String userOrderList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userOrderList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserOrdersVO vo = new UserOrdersVO();
		
		UserCardVO card = userService.getUserCard(user_num);
		UserOrdersVO orderCount = userService.orderCheck(user_num);
		if (vo.getSearch_order() == null) {
			vo.setSearch_order("");
		}
		model.addAttribute("orderCount", orderCount);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_total_point", card.getUser_total_point());
		model.addAttribute("delivering_items", card.getDelivering_items());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate oneMonthAgo = currentDate.minusMonths(1);
		oneMonthAgo = oneMonthAgo.plusDays(1);
		Date startDate = Date.from(oneMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));

		List<UserOrdersVO> list = userService.getUserOrderList(vo);
		Map<Integer, List<UserOrdersVO>> map = list.stream().collect(Collectors.groupingBy(UserOrdersVO::getOrder_num));
		// order_num을 기준으로 내림차순으로 정렬된 TreeMap 생성
		Map<Integer, List<UserOrdersVO>> sortedMap = new TreeMap<>(Comparator.reverseOrder());
		sortedMap.putAll(map);
		model.addAttribute("orderMap", sortedMap); // sortedMap을 추가해야 함

		return "user_order_list.jsp";
	}

	// 주문/배송 조회 검색
		@RequestMapping("/changeOrderList.do")
		public String changeOrderList(@RequestParam String sDate, @RequestParam String eDate, HttpServletRequest request,
				Model model) {
			System.out.println("UserController: changeOrderList");

			HttpSession session = request.getSession();
			int user_num = (int) session.getAttribute("user_num");

			UserCardVO card = userService.getUserCard(user_num);
			model.addAttribute("rank_letter", card.getRank_letter());
			model.addAttribute("user_rank", card.getUser_rank());
			model.addAttribute("user_total_point", card.getUser_total_point());
			model.addAttribute("delivering_items", card.getDelivering_items());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date startDate = java.sql.Date.valueOf(sDate);
			java.sql.Date endDate = java.sql.Date.valueOf(eDate);
			model.addAttribute("startDate", sdf.format(startDate));
			model.addAttribute("endDate", sdf.format(endDate));

			UserOrdersVO vo = new UserOrdersVO();
			vo.setUser_num(user_num);
			vo.setStartDate(startDate);
			vo.setEndDate(endDate);

			List<UserOrdersVO> list = userService.getUserOrderList(vo);
			Map<Integer, List<UserOrdersVO>> map = list.stream().collect(Collectors.groupingBy(UserOrdersVO::getOrder_num));
			// order_num을 기준으로 내림차순으로 정렬된 TreeMap 생성
			Map<Integer, List<UserOrdersVO>> sortedMap = new TreeMap<>(Comparator.reverseOrder());
			sortedMap.putAll(map);
			model.addAttribute("orderMap", sortedMap); // sortedMap을 추가해야 함

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
