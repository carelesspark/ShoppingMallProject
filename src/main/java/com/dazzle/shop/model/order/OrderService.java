	package com.dazzle.shop.model.order;

import java.util.List;

public interface OrderService {
	
	OrderVO getOrderInfo(int orderDetailNum);
	
	OrderVO getOrderDetailInfo(OrderVO vo);
	
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
	
	OrderVO getProductOrder(int productCode, int amount);
	
	OrderVO getPoint(int user_num);

	List<OrderVO> getOrderList2(OrderVO vo, int date);
	
	List<OrderVO> getProductOrderFromCart(OrderVO vo);
	
	List<OrderVO> getProductOrderWhenSuccess(OrderVO vo);
	
	OrderVO getOrderSuccInfo(OrderVO vo);
	
	void updatePoints2(OrderVO vo);
	
	void updateOrderState(OrderVO vo);
	
	void updateOrderDelv(OrderVO vo);
	
	void updatePoints(OrderVO vo);
	
	OrderVO getRefundInfo(OrderVO vo);
	
	void approveRequest(OrderVO vo);
	
	List<OrderVO> getOrderListAdmin();
	
	List<OrderVO> getOrderListAdminState(OrderVO vo);
	
	List<OrderVO> getOrderListAdminPName(OrderVO vo);
	
	List<OrderVO> getRefundList();
	
	List<OrderVO> getRefundListPName(OrderVO vo);
	
	List<OrderVO> getRefundListApprove(OrderVO vo);

	List<OrderVO> getProductState();
	
	OrderVO getOrderResponseDetail(int orderDetailNum);
	
	void insertOrderDelv(OrderVO vo) ;
	
	
}
