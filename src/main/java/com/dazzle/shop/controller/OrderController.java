package com.dazzle.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dazzle.shop.model.order.OrderVO;
import com.dazzle.shop.model.order.OrderService;
import com.dazzle.shop.model.order.impl.OrderDAO;


@Controller
@SessionAttributes("order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;


	@RequestMapping(value = "/orderList.do")
	public String getOrderList(OrderVO vo, Model model) throws Exception {

		System.out.println("글 목록 검색 처리");
		List<OrderVO> orderList = orderService.getOrderList();
		model.addAttribute("orderList", orderList);

		
		return "/order/orderList.jsp";
	}
	
	@RequestMapping(value="/orderInfo.do")
	public String getOrderInfo(OrderVO vo, Model model) throws Exception {
		
		System.out.println("글 상세 조회 처리");
		OrderVO orderInfo = orderService.getOrderInfo(vo);
		model.addAttribute("orderInfo", orderInfo);
	
		return "/order/orderInfo.jsp";
	}
}
