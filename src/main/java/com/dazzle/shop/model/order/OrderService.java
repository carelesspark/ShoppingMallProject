package com.dazzle.shop.model.order;

import java.util.List;

public interface OrderService {
	
	List<OrderListVO> getOrderList(OrderListVO vo);

}
