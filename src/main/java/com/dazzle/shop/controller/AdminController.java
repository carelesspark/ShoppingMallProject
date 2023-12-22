package com.dazzle.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	/*
	 * 회원 관리
	 */
	/*
	 * 회원 목록
	 */
	@GetMapping("/userList.do")
	public String adminUserList(Model model) {
		System.out.println("AdminController: adminUserList");
		
		int pageSize = 10;
		int pageNum = 1;
		
		List<AdminUserVO> list = adminService.getUserList(pageSize, pageNum);
		model.addAttribute("userList", list);
		
		return "admin_user_list.jsp";
	}

	/*
	 * 블랙리스트 목록
	 */

	/*
	 * 상품 관리
	 */
	/*
	 * 상품 목록
	 */
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
