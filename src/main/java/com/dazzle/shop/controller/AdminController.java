package com.dazzle.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazzle.shop.model.admin.domain.*;
import com.dazzle.shop.model.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
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

	/*
	 * 주문 관리
	 */
	/*
	 * 주문 목록
	 */
	/*
	 * 배송 목록
	 */
	/*
	 * 취소/환불 요청 목록
	 */
	/*
	 * 반품 요청 목록
	 */

}
