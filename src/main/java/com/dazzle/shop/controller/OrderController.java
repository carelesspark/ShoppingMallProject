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
import com.dazzle.shop.model.address.AddressService;
import com.dazzle.shop.model.address.AddressVO;
import com.dazzle.shop.model.order.OrderService;
import com.dazzle.shop.model.order.impl.OrderDAO;


@Controller
@SessionAttributes("order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;


	@RequestMapping(value = "/orderList.do")
	public String getOrderList(OrderVO vo, Model model) throws Exception {

		System.out.println("글 목록 검색 처리");
		List<OrderVO> orderList = orderService.getOrderList(vo);
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
	
	@RequestMapping(value="/returnOrderList.do")
	public String returnOrderList(OrderVO vo, Model model) throws Exception {
		
		model.addAttribute("user_num", vo.getUser_num());
	
		return "redirect:orderList.do";
	}
		
	// 주문 상세 페이지에서 바로 구매할 때,
	@RequestMapping(value="/productOrder.do")
	public String getProductOrder(int user_num,String product_code,int amount,Model model) throws Exception {
		System.out.println("상품 주문 페이지 이동(상품 상세페이지로 부터)");
		
		List<OrderVO> productOrder = orderService.getProductOrder(product_code, amount);
		OrderVO userPoint = orderService.getPoint(user_num);
		AddressVO address = addressService.getBaseAddress(user_num);
		
		model.addAttribute("userPoint", userPoint);
		model.addAttribute("productOrder", productOrder);
		model.addAttribute("address", address);
		System.out.println(productOrder);

		return "/order/productOrder.jsp";
	}
	
	// 장바구니 페이지에서 구매할 때,
	@RequestMapping(value="/productOrderFromCart.do")
	public String getProductOrderFromCart(int user_num, OrderVO vo, Model model) throws Exception {
		System.out.println("상품 주문 페이지 이동(장바구니로 부터)");
		List<OrderVO> productOrder = orderService.getProductOrderFromCart(vo);
		AddressVO address = addressService.getBaseAddress(user_num);
		model.addAttribute("address", address);
		
		model.addAttribute("productOrder", productOrder);
		
		System.out.println(productOrder);
			
		return "/order/productOrder.jsp";
	}
	
	
	
	@RequestMapping(value="/order.do")
	public String insertBuyOrder(List<OrderVO> orderList, Model model) throws Exception{
		System.out.println("주문 목록 입력 처리");
		
	
//		orderService.insertBuyOrder(vo);
//		orderService.insertBuyOrderDetail(vo);
		
		
		
		/*
		 * List<OrderVO> orderSuccess = orderService.getProductOrderWhenSuccess(vo);
		 * model.addAttribute("orderSuccess", orderSuccess);
		 */
		
		
		//orderSuccess부분을 List가 아니라 vo에 대한 insertBuyOrder에 대한 동작을 마치고 난 후 vo의 값과 일치하는 orders에 존재하는 order_num을 반환하여 보내줘야함 
		//model.addAttribute("order_num", order_num); 주문 번호 필요
		return "redirect:orderSuccess.do";
	}
	
	@RequestMapping(value="/orderSuccess.do")
	public String getOrderSucc(OrderVO vo, Model model) throws Exception{
		System.out.println("주문 완료 정보");
		//order_num과 일치하는 orders 값들 다 가져옴
		
		//orders와 order_detail을 join한 list형 값 가져옴
		
		
		return "/order/productOrderSucc.jsp";
	}
	
	@RequestMapping(value="/orderRefund.do")
	public String getOrderRefund(OrderVO vo, Model model) throws Exception {
		System.out.println("주문 취소/환불 요청 페이지 이동");
		
		OrderVO orderRefund = orderService.getOrderRefund(vo);
		model.addAttribute("orderRefund", orderRefund);
		
		System.out.println(orderRefund);
		
		return "/order/orderRefund.jsp";
	}
	
	@RequestMapping(value="/insertOrderRefund.do")
	public String insertOrderRefund(OrderVO vo, Model model) throws Exception {
		System.out.println("주문 취소/환불 요청");
		
		orderService.insertOrderRefund(vo);
		orderService.updateProduct_state(vo);
		model.addAttribute("order_num", vo.getOrder_num());
		
		return "redirect:orderInfo.do";
	}
	
	@RequestMapping(value="/productChange.do")
	public String getOrderChange(OrderVO vo, Model model) throws Exception {
		System.out.println("주문 취소/환불 요청 페이지 이동");
		
		OrderVO orderRefund = orderService.getOrderRefund(vo);
		model.addAttribute("orderRefund", orderRefund);
		
		System.out.println(orderRefund);
		
		return "/order/productChange.jsp";
	}
	
}
