package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dazzle.shop.model.faq.*;
import com.dazzle.shop.model.user.domain.UserCardVO;
import com.dazzle.shop.model.user.domain.UserOrdersVO;
import com.dazzle.shop.model.user.service.UserService;
@Controller
public class FaqController {
	
	@Autowired
	private FaqService faqService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/faq.do")
	public String getFaqCtgr(HttpSession session,Integer sub_ctgr_num,Integer curr_page, Model model){
		Integer pageSize = 5;
		
		if(curr_page == null) {
			curr_page = 1;
		}
		Integer faqCount = 0;
		List<FaqVO> faqCtgr = faqService.getCtgr();
		List<FaqVO> faqSubCtgr = faqService.getSubCtgr();
		int total_pages = 0;
		Integer remain = 0 ;
		List<FaqVO> faq = new ArrayList();
		if(sub_ctgr_num == null) {
			faqCount = faqService.getFaqCount();
			remain = faqCount - (pageSize * (curr_page - 1));
			faq = faqService.getFaqList(Math.min(remain, pageSize), (curr_page-1)*pageSize);
		}else {
			faqCount = faqService.getFaqSubCtgrCount(sub_ctgr_num);
			remain = faqCount - (pageSize * (curr_page - 1));
			faq = faqService.getFaqSubCtgr(Math.min(remain, pageSize), (curr_page-1)*pageSize,sub_ctgr_num);
			model.addAttribute("sub_ctgr_num", sub_ctgr_num);
			FaqVO currCtgr = faqService.getCurrCtgr(sub_ctgr_num);
			model.addAttribute("currCtgr", currCtgr);
		}
		total_pages = (int)Math.ceil((double) faqCount / pageSize);
		model.addAttribute("totalPages", total_pages);
		model.addAttribute("curr_page", curr_page);
		model.addAttribute("faq", faq);
		model.addAttribute("faqCtgr", faqCtgr);
		model.addAttribute("faqSubCtgr", faqSubCtgr);
		
		
		int user_num = 0;
		if (session.getAttribute("user_num") != null) {
			user_num = (int) session.getAttribute("user_num");
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
		}
		return "/faq/faq.jsp";
	}
	
	@GetMapping(value="/faqWrite.do")
	public String getFaqWrite(HttpSession session, Model model){
		List<FaqVO> detailCtgr = faqService.getDetailCtgr();
		model.addAttribute("detailCtgr", detailCtgr);
		

		int user_num = 0;
		if (session.getAttribute("user_num") != null) {
			user_num = (int) session.getAttribute("user_num");
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
		}
		
		return "/faq/faqWrite.jsp";
	}
	
	@PostMapping(value="/faqWrite.do")
	public String postFaqWrite(FaqVO vo){
		faqService.insertFaq(vo);
		
		return "redirect:faq.do";
	}
	
	@GetMapping(value="/faqEdit.do")
	public String getFaqEdit(HttpSession session,FaqVO vo, Model model){
		List<FaqVO> detailCtgr = faqService.getDetailCtgr();
		model.addAttribute("detailCtgr", detailCtgr);
		
		FaqVO faq = faqService.getFaq(vo);
		model.addAttribute("faq", faq);

		int user_num = 0;
		if (session.getAttribute("user_num") != null) {
			user_num = (int) session.getAttribute("user_num");
			UserOrdersVO userVo = new UserOrdersVO();
	
			UserCardVO card = userService.getUserCard(user_num);
			UserOrdersVO orderCount = userService.orderCheck(user_num);
			if (userVo.getSearch_order() == null) {
				userVo.setSearch_order("");
			}
			model.addAttribute("orderCount", orderCount);
			model.addAttribute("rank_letter", card.getRank_letter());
			model.addAttribute("user_rank", card.getUser_rank());
			model.addAttribute("user_total_point", card.getUser_total_point());
			model.addAttribute("delivering_items", card.getDelivering_items());
		}
		return "/faq/faqEdit.jsp";
	}
	
	@PostMapping(value="/faqEdit.do")
	public String postFaqEdit(FaqVO vo){
		System.out.println(vo);
		faqService.updateFaq(vo);
		
		return "redirect:faq.do";
	}
	
	@RequestMapping(value="/faqDelete.do")
	public String deleteFaq(FaqVO vo){
		faqService.deleteFaq(vo);
		
		return "redirect:faq.do";
	}
}
