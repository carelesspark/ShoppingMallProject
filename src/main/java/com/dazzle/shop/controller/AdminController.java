package com.dazzle.shop.controller;

import java.util.List;

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
	/*
	 * 회원 목록
	 */
	@GetMapping("/userList.do")
	public String adminUserList(Model model) {
		System.out.println("AdminController: adminUserList");

		int totalRecordNum = adminService.countTableRecord("user_info");
		int pageSize = 10;
		int pageNum = 1;
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalRecordNum / pageSize + 1);

		List<AdminUserVO> list = adminService.getUserList(pageSize, pageNum);
		model.addAttribute("userList", list);

		return "admin_user_list.jsp";
	}
	// 회원 목록 - 페이지 당 행 개수(비동기)
	// 회원 목록 - 페이지 이동(비동기)

	/*
	 * 블랙리스트 목록
	 */

	// 상품 관리
	// 상품 목록
	@GetMapping("/productList.do")
	public String adminProductList(Model model) {
		System.out.println("AdminController: adminProductList");

		List<SubCategoryVO> subCategory = adminService.getSubCategoryList();
		model.addAttribute("subCategory", subCategory);
		model.addAttribute("subCategoryStartNum", 1);

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

	// 상품 목록(ajax)
	// 카테고리 버튼 누르면 그에 맞는 상품 리스트 보여줌
	@GetMapping("/changeProductList.do")
	public String changeProductList(@RequestParam("subCategoryNum") int subCategoryNum,
			@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, Model model) {
		System.out.println("AdminController: changeProductList");

		model.addAttribute("subCategoryStartNum", subCategoryNum);
		List<AdminProductVO> list = adminService.getProductList(subCategoryNum, pageSize, pageNum);
		model.addAttribute("productList", list);

		return "admin_product_list.jsp";
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
