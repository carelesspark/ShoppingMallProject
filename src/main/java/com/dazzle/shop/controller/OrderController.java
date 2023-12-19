package com.dazzle.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
	// 주문 상세 페이지에서 바로 구매할 때,
	@RequestMapping(value="/productOrder.do")
	public String getProductOrder(@RequestParam(name = "user_num") int userNum, @RequestParam(name = "product_code") String productCode, @RequestParam(name = "count") int count, @RequestParam(name = "amount") int amount, OrderVO vo, Model model) throws Exception {
		System.out.println("상품 주문 페이지 이동(상품 상세페이지로 부터)");
		
		OrderVO productOrder = orderService.getProductOrder(userNum, productCode, amount, vo);

		
		
		
		
		return "/order/productOrder2.jsp";
	}
	
	// 장바구니 페이지에서 구매할 때,
	@RequestMapping(value="/productOrderFromCart.do")
	public String getProductOrderFromCart(OrderVO vo, Model model) throws Exception {
		System.out.println("상품 주문 페이지 이동(장바구니로 부터)");
		List<OrderVO> productOrder = orderService.getProductOrderFromCart(vo);
		
		model.addAttribute("productOrder", productOrder);
			
		return "/order/productOrder.jsp";
	}
	
	
	
	@RequestMapping(value="/buyOrder.do")
	public String insertBuyOrder(OrderVO vo, Model model) throws Exception{
		System.out.println("주문 목록 입력 처리");
		
		List<OrderVO> buyOrder = orderService.insertBuyOrder(vo);
		
		return "/product/productOrderSucc.jsp";
	}
}
