package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dazzle.shop.model.faq.*;
@Controller
public class FaqController {
	
	@Autowired
	private FaqService faqService;
	
	@RequestMapping(value="/faq.do")
	public String getFaqCtgr(Integer sub_ctgr_num,Integer curr_page, Model model){
		Integer pageSize = 5;
		
		if(curr_page == null) {
			curr_page = 1;
		}
		Integer faqCount = 0;
		List<FaqCtgrVO> faqCtgr = faqService.getCtgr();
		List<FaqSubCtgrVO> faqSubCtgr = faqService.getSubCtgr();
		int total_pages = 0;
		Integer remain = 0 ;
		List<FaqVO> faq = new ArrayList();
		if(sub_ctgr_num == null) {
			faqCount = faqService.getFaqCount();
			remain = faqCount - (pageSize * (curr_page - 1));
			faq = faqService.getFaq(Math.min(remain, pageSize), (curr_page-1)*pageSize);
		}else {
			faqCount = faqService.getFaqSubCtgrCount(sub_ctgr_num);
			remain = faqCount - (pageSize * (curr_page - 1));
			faq = faqService.getFaqSubCtgr(Math.min(remain, pageSize), (curr_page-1)*pageSize,sub_ctgr_num);
			model.addAttribute("sub_ctgr_num", sub_ctgr_num);
			FaqTotalCtgrVO currCtgr = faqService.getCurrCtgr(sub_ctgr_num);
			model.addAttribute("currCtgr", currCtgr);
		}
		total_pages = (int)Math.ceil((double) faqCount / pageSize);
		model.addAttribute("totalPages", total_pages);
		model.addAttribute("curr_page", curr_page);
		model.addAttribute("faq", faq);
		model.addAttribute("faqCtgr", faqCtgr);
		model.addAttribute("faqSubCtgr", faqSubCtgr);
		
		
		return "/faq/faq.jsp";
	}
	
	
}
