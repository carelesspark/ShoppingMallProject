package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
import com.dazzle.shop.model.user.domain.UserCardVO;
import com.dazzle.shop.model.user.domain.UserOrdersVO;
import com.dazzle.shop.model.user.domain.UserVO;
import com.dazzle.shop.model.user.service.UserService;

@Controller
@SessionAttributes("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;
  @Autowired
	private UserService userService;
	
	@RequestMapping(value = "/orderListAdmin.do")
	public String getOrderListAdmin(OrderVO vo, Model model) throws Exception {
		System.out.println("관리자 주문 목록 조회");
		List<OrderVO> productStateList = orderService.getProductState();
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		if(vo.getProduct_state() != null && vo.getProduct_state() != ""){
			orderList = orderService.getOrderListAdminState(vo);
			model.addAttribute("product_state", vo.getProduct_state());
		}
		else if(vo.getProduct_name() != null) {
			orderList = orderService.getOrderListAdminPName(vo);
		}
		else {
			orderList = orderService.getOrderListAdmin();
		}
		
		model.addAttribute("orderList", orderList);
		model.addAttribute("productStateList", productStateList);
		return "/order/orderListAdmin.jsp";
	}
	
	@RequestMapping(value = "/orderRefundOrChange.do")
	public String getRefundList(OrderVO vo, Model model) throws Exception {
		System.out.println("환불/교환 요청 조회");
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		if(vo.getProduct_name() != null){
			orderList = orderService.getRefundListPName(vo);
		}
		else if(vo.getApprove_search() == 1 && vo.getApprove() != 2) {
			orderList = orderService.getRefundListApprove(vo);
			model.addAttribute("approve", vo.getApprove());
		}
		else {
			orderList = orderService.getRefundList();
		}
		
		model.addAttribute("orderList", orderList);

		return "/order/orderRefundOrChange.jsp";
		
	}

	@RequestMapping(value = "/orderListDate.do")
	public String getOrderList2(OrderVO vo, @RequestParam(name = "date") Integer date, Model model) throws Exception {
		System.out.println("글 목록 검색 처리");
		if (date == null) {
			List<OrderVO> orderList = orderService.getOrderList(vo);
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
		} else if (date == 3) {
			List<OrderVO> orderList = orderService.getOrderList2(vo, (int) date);
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
		} else if (date == 6) {
			List<OrderVO> orderList = orderService.getOrderList2(vo, (int) date);
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
		} else if (date == 12) {
			List<OrderVO> orderList = orderService.getOrderList2(vo, (int) date);
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
		}

		return "redirect:orderList.do";
	}


	


	@RequestMapping(value = "/orderInfo.do")
	public String getOrderInfo(HttpServletRequest request, OrderVO vo, Model model) throws Exception {

		System.out.println("글 상세 조회 처리");
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_total_point", card.getUser_total_point());
		model.addAttribute("delivering_items", card.getDelivering_items());
		OrderVO orderInfo = orderService.getOrderInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/order/orderInfo.jsp";
	}
	
	@RequestMapping(value = "/orderInfoAdmin.do")
	public String getOrderInfoAdmin(OrderVO vo, Model model) throws Exception {

		System.out.println("글 상세 조회 처리(관리자)");
		OrderVO orderInfo = orderService.getOrderDetailInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/order/orderInfoAdmin.jsp";
	}
	
	@GetMapping(value = "/orderInfoEdit.do")
	public String getOrderInfoEditGet(OrderVO vo, Model model) throws Exception {

		System.out.println("글 수정 조회");
		OrderVO orderInfo = orderService.getOrderDetailInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/order/orderInfoEdit.jsp";
	}
	
	@PostMapping(value = "/orderInfoEdit.do")
	public String getOrderInfoEditPost(OrderVO vo, Model model) throws Exception {
		System.out.println(vo);
		System.out.println("글 수정");
		
		orderService.updateOrderState(vo); 
		orderService.updateOrderDelv(vo);
		

		return "redirect:orderInfoEdit.do?order_detail_num="+vo.getOrder_detail_num();
	}
	
	@RequestMapping(value = "/orderRefundInfo.do")
	public String orderRefundInfo(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 조회");
		OrderVO orderInfo = orderService.getRefundInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/order/orderRefundInfo.jsp";
	}
	
	@GetMapping(value = "/orderRefundAccept.do")
	public String orderRefundAcceptGet(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 승인 페이지");
		OrderVO orderInfo = orderService.getRefundInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/order/orderRefundAccept.jsp";
	}
	
	@PostMapping(value = "/orderRefundAccept.do")
	public String orderRefundAcceptPost(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 승인");
		orderService.approveRequest(vo);
		String refund_or_change = "";
		if(vo.getChange() == 1)
			refund_or_change += "교환";
		else if(vo.getCancel() == 1)
			refund_or_change += "환불";
	
		if(vo.getApprove() == 1)
			refund_or_change += " 승인";
		else if(vo.getApprove() == -1)
			refund_or_change += " 거절";
		
		System.out.println(refund_or_change);
		vo.setProduct_state(refund_or_change);
		orderService.updateOrderState(vo);

		return "redirect:orderRefundInfo.do?refund_change_num="+vo.getRefund_change_num();
	}

	@RequestMapping(value = "/returnOrderList.do")
	public String returnOrderList(OrderVO vo, Model model) throws Exception {

		model.addAttribute("user_num", vo.getUser_num());

		return "redirect:orderList.do";
	}

	// 주문 상세 페이지에서 바로 구매할 때,
	@RequestMapping(value = "/productOrder.do")
	public String getProductOrder(HttpServletRequest request, int product_code, int amount, Model model) throws Exception {
		System.out.println("상품 주문 페이지 이동(상품 상세페이지로 부터)");
		
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");
		
		List<OrderVO> productOrder = new ArrayList();
		OrderVO product = orderService.getProductOrder(product_code, amount);
		productOrder.add(product);

		UserCardVO card = userService.getUserCard(user_num);
		AddressVO address = addressService.getBaseAddress(user_num);

		model.addAttribute("user_num", user_num);
		model.addAttribute("userPoint", card.getUser_total_point());
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
		UserCardVO card = userService.getUserCard(user_num);
		AddressVO address = addressService.getBaseAddress(user_num);

		model.addAttribute("user_num", user_num);
		model.addAttribute("userPoint", card.getUser_total_point());
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
	public String getOrderRefund(HttpServletRequest request, OrderVO vo, Model model) throws Exception {
		System.out.println("주문 취소/환불 요청 페이지 이동");

		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_total_point", card.getUser_total_point());
		model.addAttribute("delivering_items", card.getDelivering_items());
		
		OrderVO orderRefund = orderService.getOrderRefund(vo);
		model.addAttribute("orderRefund", orderRefund);

		System.out.println(orderRefund);

		return "/order/orderRefund.jsp";
	}

	@RequestMapping(value = "/insertOrderRefund.do")
	public String insertOrderRefund(HttpServletRequest request, OrderVO vo, Model model) throws Exception {
		System.out.println("주문 취소/환불 요청");
		
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");
		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_total_point", card.getUser_total_point());
		model.addAttribute("delivering_items", card.getDelivering_items());

		orderService.insertOrderRefund(vo);
		orderService.updateProduct_state(vo);
		model.addAttribute("order_num", vo.getOrder_num());

		return "redirect:orderInfo.do";
	}

	@RequestMapping(value = "/productChange.do")
	public String getproductChange(HttpServletRequest request, OrderVO vo, Model model) throws Exception {
		System.out.println("상품 교환 요청 페이지 이동");
		
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");
		UserCardVO card = userService.getUserCard(user_num);
		model.addAttribute("rank_letter", card.getRank_letter());
		model.addAttribute("user_rank", card.getUser_rank());
		model.addAttribute("user_total_point", card.getUser_total_point());
		model.addAttribute("delivering_items", card.getDelivering_items());
		
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
