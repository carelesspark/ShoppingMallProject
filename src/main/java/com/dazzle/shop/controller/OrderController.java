package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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

	/*
	 * @RequestMapping(value = "/orderList.do") public String getOrderList(OrderVO
	 * vo, Model model) throws Exception { System.out.println("글 목록 검색 처리");
	 * 
	 * List<OrderVO> orderList = orderService.getOrderList(vo);
	 * model.addAttribute("orderList", orderList); System.out.println(orderList);
	 * 
	 * return "/user/user_order_list.jsp"; }
	 * 
	 * @RequestMapping(value = "/orderListDate.do") public String
	 * getOrderList2(OrderVO vo, @RequestParam(name = "date") Integer date, Model
	 * model) throws Exception { System.out.println("글 목록 검색 처리"); if (date == null)
	 * { List<OrderVO> orderList = orderService.getOrderList(vo);
	 * model.addAttribute("orderList", orderList); System.out.println(orderList); }
	 * else if (date == 3) { List<OrderVO> orderList =
	 * orderService.getOrderList2(vo, (int) date); model.addAttribute("orderList",
	 * orderList); System.out.println(orderList); } else if (date == 6) {
	 * List<OrderVO> orderList = orderService.getOrderList2(vo, (int) date);
	 * model.addAttribute("orderList", orderList); System.out.println(orderList); }
	 * else if (date == 12) { List<OrderVO> orderList =
	 * orderService.getOrderList2(vo, (int) date); model.addAttribute("orderList",
	 * orderList); System.out.println(orderList); }
	 * 
	 * return "redirect:orderList.do"; }
	 */

	@RequestMapping(value = "/orderInfo.do")
	public String getOrderInfo(OrderVO vo, Model model) throws Exception {

		System.out.println("글 상세 조회 처리");
		OrderVO orderInfo = orderService.getOrderInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/order/orderInfo.jsp";
	}

	@RequestMapping(value = "/returnOrderList.do")
	public String returnOrderList(OrderVO vo, Model model) throws Exception {

		model.addAttribute("user_num", vo.getUser_num());

		return "redirect:orderList.do";
	}

	// 주문 상세 페이지에서 바로 구매할 때,
	@RequestMapping(value = "/productOrder.do")
	public String getProductOrder(int user_num, int product_code, int amount, Model model) throws Exception {
		System.out.println("상품 주문 페이지 이동(상품 상세페이지로 부터)");
		List<OrderVO> productOrder = new ArrayList();
		OrderVO product = orderService.getProductOrder(product_code, amount);
		productOrder.add(product);

		OrderVO userPoint = orderService.getPoint(user_num);
		AddressVO address = addressService.getBaseAddress(user_num);

		model.addAttribute("user_num", user_num);
		model.addAttribute("userPoint", userPoint);
		model.addAttribute("productOrder", productOrder);
		model.addAttribute("address", address);
		System.out.println(productOrder);

		return "/order/productOrder.jsp";
		
	}

	// 장바구니 페이지에서 구매할 때,
	@RequestMapping(value = "/productOrderFromCart.do")
	public String getProductOrderFromCart(HttpServletRequest request, OrderVO vo, Model model) throws Exception {
		System.out.println(vo);
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		List<OrderVO> productOrder = new ArrayList();
		for (int i = 0; i < vo.getProduct_code_list().size(); i++) {
			if (vo.getCheckbox().get(i) == 1) {
				OrderVO product = orderService.getProductOrder(vo.getProduct_code_list().get(i), vo.getAmount_list().get(i));
				productOrder.add(product);
			}
		}
		OrderVO userPoint = orderService.getPoint(user_num);
		AddressVO address = addressService.getBaseAddress(user_num);

		model.addAttribute("user_num", user_num);
		model.addAttribute("userPoint", userPoint);
		model.addAttribute("productOrder", productOrder);
		model.addAttribute("address", address);

		return "/order/productOrder.jsp";
	}

	@RequestMapping(value = "/order.do")
	public String insertBuyOrder(OrderVO vo, Model model) throws Exception {
		System.out.println("주문 목록 입력 처리");

		orderService.insertBuyOrder(vo);
		int order_num = orderService.getBuyOrder(vo).getOrder_num();
		if (vo.getProduct_code_list().size() == 1) {
			vo.setProduct_code(vo.getProduct_code_list().get(0));
			vo.setAmount((int) vo.getAmount_list().get(0));
			vo.setAmountMultiPrice(vo.getAmountMultiPrice_list().get(0));
			vo.setOrder_num(order_num);
			orderService.insertBuyOrderDetail(vo);
		} else {
			for (int i = 0; i < vo.getProduct_code_list().size(); i++) {
				OrderVO product = new OrderVO();
				product.setProduct_code(vo.getProduct_code_list().get(i));
				product.setAmount((int) vo.getAmount_list().get(i));
				product.setAmountMultiPrice(vo.getAmountMultiPrice_list().get(i));
				product.setOrder_num(order_num);
				orderService.insertBuyOrderDetail(product);
			}
		}

		model.addAttribute("order_num", order_num);
		return "redirect:orderSuccess.do";
	}

	@RequestMapping(value = "/orderSuccess.do")
	public String getOrderSucc(OrderVO vo, Model model) throws Exception {
		System.out.println("주문 완료 정보");
	  OrderVO order = orderService.getOrderSuccInfo(vo);
		List<OrderVO> productList = orderService.getProductOrderWhenSuccess(vo);
		model.addAttribute("order", order);
		model.addAttribute("productList", productList);
		return "/order/productOrderSucc.jsp";
	}

	@RequestMapping(value = "/orderRefund.do")
	public String getOrderRefund(OrderVO vo, Model model) throws Exception {
		System.out.println("주문 취소/환불 요청 페이지 이동");

		OrderVO orderRefund = orderService.getOrderRefund(vo);
		model.addAttribute("orderRefund", orderRefund);

		System.out.println(orderRefund);

		return "/order/orderRefund.jsp";
	}

	@RequestMapping(value = "/insertOrderRefund.do")
	public String insertOrderRefund(OrderVO vo, Model model) throws Exception {
		System.out.println("주문 취소/환불 요청");

		orderService.insertOrderRefund(vo);
		orderService.updateProduct_state(vo);
		model.addAttribute("order_num", vo.getOrder_num());

		return "redirect:orderInfo.do";
	}

	@RequestMapping(value = "/productChange.do")
	public String getproductChange(OrderVO vo, Model model) throws Exception {
		System.out.println("상품 교환 요청 페이지 이동");

		OrderVO productChange = orderService.getProductChange(vo);
		model.addAttribute("productChange", productChange);
		System.out.println(productChange);

		return "/order/productChange.jsp";
	}

	@RequestMapping(value = "/insertProductChange.do")
	public String insertProductChange(OrderVO vo, Model model) throws Exception {
		System.out.println("상품 교환 요청");

		orderService.insertProductChange(vo);
		orderService.updateProduct_state2(vo);
		model.addAttribute("order_num", vo.getOrder_num());

		return "redirect:orderInfo.do";
	}

}
