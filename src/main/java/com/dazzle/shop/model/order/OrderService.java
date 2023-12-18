	package com.dazzle.shop.model.order;

import java.util.List;

public interface OrderService {
	
	OrderVO getOrderInfo(OrderVO vo);
	
	List<OrderVO> getOrderList();

}
