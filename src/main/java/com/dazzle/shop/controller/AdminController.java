package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazzle.shop.model.admin.domain.*;
import com.dazzle.shop.model.admin.service.AdminService;
import com.dazzle.shop.model.order.OrderService;
import com.dazzle.shop.model.order.OrderVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private OrderService orderService;
	/*
	 * 매출 관리
	 */
	/*
	 * 매출 목록
	 */
	/*
	 * 가계부
	 */

	// 회원 관리
	// 회원 목록
	@GetMapping("/userList.do")
	public String adminUserList(Model model) {
		System.out.println("AdminController: adminUserList");

		int totalItems = adminService.countTableRecord("user_info"); // 유저 총 개수
		int itemsPerPage = 20; // 페이지 당 표시할 레코드 수
		int currentPage = 1; // 현재 페이지
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		List<AdminUserVO> list = adminService.getUserList(currentPage, itemsPerPage);
		model.addAttribute("userList", list);

		int realItemsPerPage = list.size(); // 마지막 페이지인 경우에는 레코드 수가 20개 이하일 수 있다.
		int realItemsStartNum = totalItems - ((currentPage - 1) * itemsPerPage);
		model.addAttribute("realItemsPerPage", realItemsPerPage);
		model.addAttribute("realItemsStartNum", realItemsStartNum);

		return "admin_user_list.jsp";
	}

	// 회원 목록 - 페이지 당 행 개수
	// 회원 목록 - 페이지 이동
	@GetMapping("/changeUserList.do")
	public String changeUserList(@RequestParam("itemsPerPage") int itemsPerPage,
			@RequestParam("currentPage") int currentPage, Model model) {
		System.out.println("AdminController: changeUserList");

		int totalItems = adminService.countTableRecord("user_info"); // 유저 총 개수
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		List<AdminUserVO> list = adminService.getUserList(currentPage, itemsPerPage);
		model.addAttribute("userList", list);

		int realItemsPerPage = list.size(); // 마지막 페이지인 경우에는 레코드 수가 20개 이하일 수 있다.
		int realItemsStartNum = totalItems - ((currentPage - 1) * itemsPerPage);
		model.addAttribute("realItemsPerPage", realItemsPerPage);
		model.addAttribute("realItemsStartNum", realItemsStartNum);

		return "admin_user_list.jsp";
	}

	// 블랙리스트 목록
	@GetMapping("/userBlacklist.do")
	public String userBlacklist(Model model) {
		System.out.println("AdminController: userBlacklist");

		int totalRecordNum = adminService.countBlacklist();
		int pageSize = 10;
		int pageNum = 1;
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalRecordNum / pageSize + 1);

		List<AdminUserVO> list = adminService.getBlackist(pageSize, pageNum);
		model.addAttribute("userList", list);

		return "admin_user_list.jsp";
	}

	// 상품 관리
	// 상품 목록
	@GetMapping("/productList.do")
	public String adminProductList(Model model) {
		System.out.println("AdminController: adminProductList");

		List<SubCategoryVO> subCategory = adminService.getSubCategoryList();
		model.addAttribute("subCategory", subCategory);
		model.addAttribute("subCategoryNum", 0);
		model.addAttribute("subCategoryStartNum", 0);

		int totalRecordNum = adminService.countTableRecord("user_info");
		int pageSize = 10;
		int pageNum = 1;
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalRecordNum / pageSize + 1);

		int subCategoryNum = 1;
		List<AdminProductVO> list = adminService.getProductList(subCategoryNum, pageSize, pageNum);
		model.addAttribute("productList", list);

		return "admin_product_list.jsp";
	}

	// 카테고리 버튼 누르면 그에 맞는 상품 리스트 보여줌
	@GetMapping("/changeProductList.do")
	public String changeProductList(@RequestParam("subCategoryNum") int subCategoryNum,
			@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, Model model) {
		System.out.println("AdminController: changeProductList");

		List<SubCategoryVO> subCategory = adminService.getSubCategoryList();
		model.addAttribute("subCategory", subCategory);
		model.addAttribute("subCategoryNum", subCategoryNum);
		model.addAttribute("subCategoryStartNum", (subCategoryNum / 5) * 5);

		int totalRecordNum = adminService.countTableRecord("user_info");
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalRecordNum / pageSize + 1);

		List<AdminProductVO> list = adminService.getProductList(subCategoryNum + 1, pageSize, pageNum);
		model.addAttribute("productList", list);

		return "admin_product_list.jsp";
	}

	@GetMapping("/productDetail.do")
	public String adminProductDetail(@RequestParam("product_num") int product_num, Model model) {
		System.out.println("AdminController: adminProductDetail");

		AdminProductVO productInfo = adminService.getProductDetail(product_num);
		List<AdminProductVO> stockList = adminService.getProductStock(product_num);
		model.addAttribute("productInfo", productInfo);
		model.addAttribute("stockList", stockList);

		return "admin_product_detail.jsp";
	}
	/*
	 * 상품 추가
	 */
	/*
	 * 상품 수정
	 */
	/*
	 * 상품 삭제
	 */

	@RequestMapping(value = "/orderListAdmin.do")
	public String getOrderListAdmin(OrderVO vo, Model model) throws Exception {
		System.out.println("관리자 주문 목록 조회");
		List<OrderVO> productStateList = orderService.getProductState();
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		if(vo.getProduct_state() != null && vo.getProduct_state() != ""){
			orderList = orderService.getOrderListAdminState(vo);
			model.addAttribute("product_state", vo.getProduct_state());
		}
		else if(vo.getProduct_name() != null) {
			orderList = orderService.getOrderListAdminPName(vo);
		}
		else {
			orderList = orderService.getOrderListAdmin();
		}
		
		model.addAttribute("orderList", orderList);
		model.addAttribute("productStateList", productStateList);
		return "/admin/orderListAdmin.jsp";
	}
	
	@RequestMapping(value = "/orderRefundOrChange.do")
	public String getRefundList(OrderVO vo, Model model) throws Exception {
		System.out.println("환불/교환 요청 조회");
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		if(vo.getProduct_name() != null){
			orderList = orderService.getRefundListPName(vo);
		}
		else if(vo.getApprove_search() == 1 && vo.getApprove() != 2) {
			orderList = orderService.getRefundListApprove(vo);
			model.addAttribute("approve", vo.getApprove());
		}
		else {
			orderList = orderService.getRefundList();
		}
		
		model.addAttribute("orderList", orderList);

		return "/admin/orderRefundOrChange.jsp";
		
	}
	@RequestMapping(value = "/orderInfoAdmin.do")
	public String getOrderInfoAdmin(OrderVO vo, Model model) throws Exception {

		System.out.println("글 상세 조회 처리(관리자)");
		OrderVO orderInfo = orderService.getOrderDetailInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/admin/orderInfoAdmin.jsp";
	}
	
	@GetMapping(value = "/orderInfoEdit.do")
	public String getOrderInfoEditGet(OrderVO vo, Model model) throws Exception {

		System.out.println("글 수정 조회");
		OrderVO orderInfo = orderService.getOrderDetailInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/admin/orderInfoEdit.jsp";
	}
	
	@PostMapping(value = "/orderInfoEdit.do")
	public String getOrderInfoEditPost(OrderVO vo, Model model) throws Exception {
		System.out.println(vo);
		System.out.println("글 수정");
		
		orderService.updateOrderState(vo); 
		orderService.updateOrderDelv(vo);
		

		return "redirect:orderInfoAdmin.do?order_detail_num="+vo.getOrder_detail_num();
	}
	
	@RequestMapping(value = "/orderRefundInfo.do")
	public String orderRefundInfo(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 조회");
		OrderVO orderInfo = orderService.getRefundInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/admin/orderRefundInfo.jsp";
	}
	
	@GetMapping(value = "/orderRefundAccept.do")
	public String orderRefundAcceptGet(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 승인 페이지");
		OrderVO orderInfo = orderService.getRefundInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/admin/orderRefundAccept.jsp";
	}
	
	@PostMapping(value = "/orderRefundAccept.do")
	public String orderRefundAcceptPost(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 승인");
		orderService.approveRequest(vo);
		String refund_or_change = "";
		if(vo.getChange() == 1)
			refund_or_change += "교환";
		else if(vo.getCancel() == 1)
			refund_or_change += "환불";
	
		if(vo.getApprove() == 1)
			refund_or_change += " 승인";
		else if(vo.getApprove() == -1)
			refund_or_change += " 거절";
		
		System.out.println(refund_or_change);
		vo.setProduct_state(refund_or_change);
		orderService.updateOrderState(vo);

		return "redirect:orderRefundInfo.do?refund_change_num="+vo.getRefund_change_num();
	}

}
