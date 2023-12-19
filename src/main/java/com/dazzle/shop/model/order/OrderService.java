	package com.dazzle.shop.model.order;

import java.util.List;

public interface OrderService {
	
	OrderVO getOrderInfo(OrderVO vo);
	
	List<OrderVO> getOrderList();
	
	List<OrderVO> insertBuyOrder(OrderVO vo);
	
	OrderVO getProductOrder(int userNum, String productCode, int amount, OrderVO vo);
	
	List<OrderVO> getProductOrderFromCart(OrderVO vo);

}
