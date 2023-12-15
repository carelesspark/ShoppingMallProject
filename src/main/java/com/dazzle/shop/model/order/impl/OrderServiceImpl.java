package com.dazzle.shop.model.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.order.OrderListVO;
import com.dazzle.shop.model.order.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	@Override
	public List<OrderListVO> getOrderList(OrderListVO vo) {

		return orderDAO.getOrderList(vo);
	}
}
