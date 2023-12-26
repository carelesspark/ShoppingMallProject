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
	public OrderVO getProductOrder(String productCode, int amount) {

		return orderDAO.getProductOrder(productCode, amount);
	}
	
	@Override
	public OrderVO getPoint(int user_num) {
	
		return orderDAO.getPoint(user_num);
	}

	@Override
	public void insertBuyOrder(OrderVO vo) {
		orderDAO.insertBuyOrder(vo);
	}

	@Override
	public OrderVO getBuyOrder(OrderVO vo) {
		return orderDAO.getBuyOrder(vo);
	}
	
	
	@Override
	public void insertBuyOrderDetail(OrderVO vo) {
		orderDAO.insertBuyOrderDetail(vo);
	}

	@Override
	public void insertOrderRefund(OrderVO vo) {
		orderDAO.insertOrderRefund(vo);
	}

	@Override
	public OrderVO getProductChange(OrderVO vo) {
		
		return orderDAO.getProductChange(vo);
	}

	@Override
	public void insertProductChange(OrderVO vo) {
		
		orderDAO.insertProductChange(vo);	
	}

	@Override
	public void updateProduct_state2(OrderVO vo) {
		
		orderDAO.updateProduct_state2(vo);
		
	}

	@Override
	public void updateProduct_state(OrderVO vo) {
		orderDAO.updateProduct_state(vo);
	}

	@Override
	public List<OrderVO> getProductOrderWhenSuccess(OrderVO vo) {

		return orderDAO.getProductOrderWhenSuccess(vo);
	}

	@Override
	public OrderVO getOrderRefund(OrderVO vo) {

		return orderDAO.getOrderRefund(vo);
	}

	@Override
	public OrderVO getOrderInfo(OrderVO vo) {

		return orderDAO.getOrderInfo(vo);
	}
	
	@Override
	public OrderVO getOrderDetailInfo(OrderVO vo) {

		return orderDAO.getOrderDetailInfo(vo);
	}

	@Override
	public List<OrderVO> getOrderList(OrderVO vo) {

		return orderDAO.getOrderList(vo);
	}

	@Override
	public List<OrderVO> getOrderList2(OrderVO vo, int date) {
		
		return orderDAO.getOrderList2(vo, date);
	}
	@Override
	public OrderVO getOrderSuccInfo(OrderVO vo) {
		return orderDAO.getOrderSuccInfo(vo);
	}
	
	@Override
	public void updateOrderState(OrderVO vo) {
		
		orderDAO.updateOrderState(vo);	
	}
	
	@Override
	public void updateOrderDelv(OrderVO vo) {
		
		orderDAO.updateOrderDelv(vo);	
	}
	
	@Override
	public OrderVO getRefundInfo(OrderVO vo) {
		return orderDAO.getRefundInfo(vo);
	}
	@Override
	public void approveRequest(OrderVO vo) {
		orderDAO.approveRequest(vo);
	}
	@Override
	public List<OrderVO> getOrderListAdmin(){
		return orderDAO.getOrderListAdmin();
	}
	@Override
	public List<OrderVO> getOrderListAdminState(OrderVO vo) {
		return orderDAO.getOrderListAdminState(vo);
	}
	@Override
	public List<OrderVO> getOrderListAdminPName(OrderVO vo)
	{
		return orderDAO.getOrderListAdminPName(vo);
	}
	@Override
	public List<OrderVO> getRefundList(){
		return orderDAO.getRefundList();
	}
	@Override
	public List<OrderVO> getRefundListPName(OrderVO vo) {
		return orderDAO.getRefundListPName(vo);
	}
	@Override
	public List<OrderVO> getRefundListApprove(OrderVO vo) {
		return orderDAO.getRefundListApprove(vo);
	}
	@Override
	public List<OrderVO> getProductState(){
		return orderDAO.getProductState();
	}
}
