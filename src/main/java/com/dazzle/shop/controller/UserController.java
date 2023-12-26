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

		UserCardVO card = userService.getUserCard(user_num);
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

		UserOrdersVO vo = new UserOrdersVO();
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

	// 취소/환불 신청
	// 교환 신청

	// 나의 혜택
	// 포인트
	@RequestMapping("/pointList.do")
	public String userPointList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userPointList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate oneMonthAgo = currentDate.minusMonths(1);
		oneMonthAgo = oneMonthAgo.plusDays(1);
		Date startDate = Date.from(oneMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countPointBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int itemsPerPage = 10; // 페이지 당 표시할 레코드 수
		int currentPage = 1; // 현재 페이지
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		UserPointVO vo = new UserPointVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserPointVO> list = userService.getUserPointList(vo);
		model.addAttribute("pointList", list);

		return "user_point_list.jsp";
	}

	// 포인트 검색
	@RequestMapping("/changePointList.do")
	public String changePointList(@RequestParam String sDate, @RequestParam String eDate, @RequestParam int currentPage,
			@RequestParam int itemsPerPage, HttpServletRequest request, Model model) {
		System.out.println("UserController: changePointList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date startDate = java.sql.Date.valueOf(sDate);
		java.sql.Date endDate = java.sql.Date.valueOf(eDate);
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countPointBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("totalPage", totalPage);

		UserPointVO vo = new UserPointVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserPointVO> list = userService.getUserPointList(vo);
		model.addAttribute("pointList", list);

		return "user_point_list.jsp";
	}

	// 상품 후기
	@RequestMapping("/reviewList.do")
	public String userReviewList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userPointList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate oneMonthAgo = currentDate.minusMonths(1);
		oneMonthAgo = oneMonthAgo.plusDays(1);
		Date startDate = Date.from(oneMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countPointBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int itemsPerPage = 10; // 페이지 당 표시할 레코드 수
		int currentPage = 1; // 현재 페이지
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		UserReviewVO vo = new UserReviewVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserReviewVO> list = userService.getUserReviewList(vo);
		model.addAttribute("reviewList", list);

		return "user_review_list.jsp";
	}

	// 상품 후기 검색
	@RequestMapping("/changeReviewList.do")
	public String changeReviewList(@RequestParam String sDate, @RequestParam String eDate,
			@RequestParam int currentPage, @RequestParam int itemsPerPage, HttpServletRequest request, Model model) {
		System.out.println("UserController: changeReviewList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date startDate = java.sql.Date.valueOf(sDate);
		java.sql.Date endDate = java.sql.Date.valueOf(eDate);
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countReviewBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("totalPage", totalPage);

		UserReviewVO vo = new UserReviewVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserReviewVO> list = userService.getUserReviewList(vo);
		model.addAttribute("reviewList", list);

		return "user_review_list.jsp";
	}

	// 1:1 문의
	@RequestMapping("/inquiryList.do")
	public String userInquiryList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userInquiryList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate oneMonthAgo = currentDate.minusMonths(1);
		oneMonthAgo = oneMonthAgo.plusDays(1);
		Date startDate = Date.from(oneMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countInquiryBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int itemsPerPage = 10; // 페이지 당 표시할 레코드 수
		int currentPage = 1; // 현재 페이지
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		UserInquiryVO vo = new UserInquiryVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserInquiryVO> list = userService.getUserInquiryList(vo);
		model.addAttribute("inquiryList", list);

		return "user_inquiry_list.jsp";
	}

	// 1:1 문의 검색
	@RequestMapping("/changeInquiryList.do")
	public String changeInquiryList(@RequestParam String sDate, @RequestParam String eDate,
			@RequestParam int currentPage, @RequestParam int itemsPerPage, HttpServletRequest request, Model model) {
		System.out.println("UserController: changeInquiryList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date startDate = java.sql.Date.valueOf(sDate);
		java.sql.Date endDate = java.sql.Date.valueOf(eDate);
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countInquiryBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("totalPage", totalPage);

		UserInquiryVO vo = new UserInquiryVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserInquiryVO> list = userService.getUserInquiryList(vo);
		model.addAttribute("inquiryList", list);

		return "user_inquiry_list.jsp";
	}

	// 작성 글
	@RequestMapping("/boardList.do")
	public String userBoardList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userBoardList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate oneMonthAgo = currentDate.minusMonths(1);
		oneMonthAgo = oneMonthAgo.plusDays(1);
		Date startDate = Date.from(oneMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countBoardBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int itemsPerPage = 10; // 페이지 당 표시할 레코드 수
		int currentPage = 1; // 현재 페이지
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		UserBoardVO vo = new UserBoardVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserBoardVO> list = userService.getUserBoardList(vo);
		model.addAttribute("boardList", list);

		return "user_board_list.jsp";
	}

	// 날짜 기준 작성 글 수
	@RequestMapping("/changeBoardList.do")
	public String changeBoardList(@RequestParam String sDate, @RequestParam String eDate, @RequestParam int currentPage,
			@RequestParam int itemsPerPage, HttpServletRequest request, Model model) {
		System.out.println("UserController: changeBoardList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date startDate = java.sql.Date.valueOf(sDate);
		java.sql.Date endDate = java.sql.Date.valueOf(eDate);
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countBoardBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("totalPage", totalPage);

		UserBoardVO vo = new UserBoardVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserBoardVO> list = userService.getUserBoardList(vo);
		model.addAttribute("boardList", list);

		return "user_board_list.jsp";
	}

	// 작성 댓글
	@RequestMapping("/replyList.do")
	public String userReplyList(HttpServletRequest request, Model model) {
		System.out.println("UserController: userReplyList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate oneMonthAgo = currentDate.minusMonths(1);
		oneMonthAgo = oneMonthAgo.plusDays(1);
		Date startDate = Date.from(oneMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countReplyBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int itemsPerPage = 10; // 페이지 당 표시할 레코드 수
		int currentPage = 1; // 현재 페이지
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		UserReplyVO vo = new UserReplyVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserReplyVO> list = userService.getUserReplyList(vo);
		model.addAttribute("replyList", list);

		return "user_reply_list.jsp";
	}

	// 날짜 기준 작성 댓글 수
	@RequestMapping("/changeReplyList.do")
	public String changeReplyList(@RequestParam String sDate, @RequestParam String eDate, @RequestParam int currentPage,
			@RequestParam int itemsPerPage, HttpServletRequest request, Model model) {
		System.out.println("UserController: changeReplyList");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("delivering_items", card.getDelivering_items());
		model.addAttribute("user_total_point", card.getUser_total_point());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date startDate = java.sql.Date.valueOf(sDate);
		java.sql.Date endDate = java.sql.Date.valueOf(eDate);
		model.addAttribute("startDate", sdf.format(startDate));
		model.addAttribute("endDate", sdf.format(endDate));

		int totalItems = userService.countReplyBetweenDates(user_num, new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime())); // 해당하는 날짜 사이의 포인트 목록 총 개수
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("totalPage", totalPage);

		UserReplyVO vo = new UserReplyVO();
		vo.setUser_num(user_num);
		vo.setStartDate(new java.sql.Date(startDate.getTime()));
		vo.setEndDate(new java.sql.Date(endDate.getTime()));
		vo.setCurrentPage(currentPage);
		vo.setItemsPerPage(itemsPerPage);

		List<UserReplyVO> list = userService.getUserReplyList(vo);
		model.addAttribute("replyList", list);

		return "user_reply_list.jsp";
	}

	// 회원정보 변경 - 비밀번호 검증
	@RequestMapping("/checkInfo.do")
	public String userCheckInfo(HttpServletRequest request, Model model) {
		System.out.println("UserController: userCheckInfo");

		return "user_change_info.jsp";
	}

	// 회원정보 변경 - 정보 수정 및 업데이트
	@RequestMapping("/changeInfo.do")
	public String userChangeInfo(HttpServletRequest request, Model model) {
		System.out.println("UserController: userChangeInfo");

		return "user_order_list.jsp";
	}

}
