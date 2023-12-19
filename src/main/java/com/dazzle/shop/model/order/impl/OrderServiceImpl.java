package com.dazzle.shop.model.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.order.OrderVO;
import com.dazzle.shop.model.order.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;



	@Override
	public List<OrderVO> getProductOrderFromCart(OrderVO vo) {

		return orderDAO.getProductOrderFromCart(vo);
	}







	@Override
	public OrderVO getProductOrder(int userNum, String productCode, int amount, OrderVO vo) {

		return orderDAO.getProductOrder(vo);
	}







	@Override
	public List<OrderVO> insertBuyOrder(OrderVO vo) {

		return orderDAO.insertBuyOrder(vo);
	}



	



	@Override
	public OrderVO getOrderInfo(OrderVO vo) {
		
		return orderDAO.getOrderInfo(vo);
	}



	@Override
	public List<OrderVO> getOrderList() {

		return orderDAO.getOrderList();
	}
}
