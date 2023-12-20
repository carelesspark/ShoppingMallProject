	package com.dazzle.shop.model.order;

import java.util.List;

public interface OrderService {
	
	OrderVO getOrderInfo(OrderVO vo);
	
	OrderVO getOrderRefund(OrderVO vo);
	
	void insertBuyOrder(OrderVO vo);
	
	void insertBuyOrderDetail(OrderVO vo);

	List<OrderVO> getOrderList(OrderVO vo);
	
	List<OrderVO> getProductOrder(int userNum, String productCode, int amount, OrderVO vo);
	
	List<OrderVO> getProductOrderFromCart(OrderVO vo);
	
	List<OrderVO> getProductOrderWhenSuccess(OrderVO vo);
	
	

}
