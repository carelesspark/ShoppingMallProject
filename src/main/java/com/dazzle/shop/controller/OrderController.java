package com.dazzle.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dazzle.shop.model.order.OrderListVO;
import com.dazzle.shop.model.order.impl.OrderDAO;

public class OrderController {
	
	@RequestMapping(value="/orderList.jsp")
	public ModelAndView getOrderList(OrderListVO vo, OrderDAO dao, ModelAndView mav) throws Exception{
		
		System.out.println("글 목록 처리");
		
		List<OrderListVO> orderList = dao.getOrderList(vo);
		mav.addObject("orderList", orderList);
		mav.setViewName("orderList.jsp");
		
		return mav;
	}
}
