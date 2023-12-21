	package com.dazzle.shop.model.order;

import java.util.List;

public interface OrderService {
	
	OrderVO getOrderInfo(OrderVO vo);
	
	OrderVO getOrderRefund(OrderVO vo);
	
	OrderVO getProductChange(OrderVO vo);
	
	void insertBuyOrder(OrderVO vo);
	
	OrderVO getBuyOrder(OrderVO vo);
	
	void insertBuyOrderDetail(OrderVO vo);
	
	void insertOrderRefund(OrderVO vo);
	
	void updateProduct_state(OrderVO vo);
	
	void insertProductChange(OrderVO vo);
	
	void updateProduct_state2(OrderVO vo);

	List<OrderVO> getOrderList(OrderVO vo);
	
	List<OrderVO> getProductOrder(String productCode, int amount);
	
	OrderVO getPoint(int user_num);

	List<OrderVO> getOrderList2(OrderVO vo, int date);
	
	List<OrderVO> getProductOrderFromCart(OrderVO vo);
	
	List<OrderVO> getProductOrderWhenSuccess(OrderVO vo);
	
	
	
}
