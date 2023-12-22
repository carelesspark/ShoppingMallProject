package com.dazzle.shop.model.order.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;
import javax.servlet.http.HttpSession;

import com.dazzle.shop.model.cart.CartVO;
import com.dazzle.shop.model.order.OrderVO;

@Repository
public class OrderDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String ORDER_LIST = "SELECT o.order_num, od.product_state, o.order_date, p.product_name, p.product_price, o.user_num"
			+ " FROM orders o" + " JOIN order_detail od ON o.order_num = od.order_num"
			+ " JOIN delivery d ON d.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num" + " WHERE o.user_num = ?";

	private final String ORDER_LIST2 = "SELECT o.order_num, od.product_state, o.user_num, o.order_date, p.product_name, p.product_price"
			+ " FROM orders o" + " JOIN order_detail od ON o.order_num = od.order_num"
			+ " JOIN delivery d ON d.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num"
			+ " WHERE o.user_num = ? AND o.order_date >= DATE_SUB(NOW(), INTERVAL ? MONTH)";

	private final String ORDER_INFO = "SELECT o.order_num, ps.size_name, pco.color_name, od.amount, p.product_price, p.product_name, od.product_state, d.delivery_date, d.delivery_company, d.invoice_num, o.recipient, o.address, o.detail_address, o.phone_num, o.request, od.order_detail_num, o.user_num"
			+ " FROM orders o" + " JOIN order_detail od ON o.order_num = od.order_num"
			+ " JOIN delivery d ON d.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num" + " WHERE o.order_num = ?";

	private final String PRODUCT_ORDER = "SELECT pimg.main_img, (p.product_price * ?) AS total_price, ? AS amount, p.product_name, pco.color_name, ps.size_name, pc.product_code"
			+ " FROM product_code pc"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num"
			+ " JOIN product_img pimg ON pimg.product_num = p.product_num"
			+ " WHERE pc.product_code = ?";
	
	private final String USER_POINT = "SELECT user_point FROM user_info where user_num = ?";

	private final String PRODUCT_ORDER_CART = "SELECT pimg.main_img, (p.product_price * c.amount) AS total_price, c.amount, p.product_name, pco.color_name, ps.size_name, ui.user_point"
			+ " FROM cart c" + " JOIN users u ON u.user_num = c.user_num"
			+ " JOIN user_info ui ON ui.user_num = u.user_num"
			+ " JOIN product_code pc ON pc.product_code = c.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num"
			+ " JOIN product_img pimg ON pimg.product_num = p.product_num" + " WHERE c.user_num = ?";

	private final String BUY_ORDER = "INSERT INTO orders VALUES (DEFAULT, NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String GET_ORDER = "SELECT order_num FROM orders "
			+ "where address = ? and detail_address=? and postal_num = ? and delivery_price = ? and "
			+ "recipient = ? and request = ? and payment = ? and user_num = ? and phone_num = ? "
			+ "order by order_num desc limit 1";
	
	private final String BUY_ORDER_DETAIL = "INSERT INTO order_detail VALUES(DEFAULT, '상품 준비 중', ?, ?, ?, ?)";

	private final String SUCCESS_ORDER = "SELECT pimg.main_img, (p.product_price * ? ) AS total_price, ? AS amount, p.product_name, pco.color_name, ps.size_name, o.order_num, o.order_date, o.delivery_price"
			+ " FROM orders o" + " JOIN users u ON u.user_num = o.user_num"
			+ " JOIN order_detail od ON od.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num"
			+ " JOIN product_img pimg ON pimg.product_num = p.product_num" + " WHERE u.user_num = ?";

	private final String ORDER_REFUND = "SELECT o.order_num, o.recipient, (p.product_price * od.amount ) AS total_price, p.product_price, od.amount, od.order_detail_num"
			+ " FROM orders o" + " JOIN order_detail od ON od.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num" + " WHERE od.order_detail_num = ?";

	private final String ORDER_REFUND_REQ = "INSERT INTO product_refund_or_change VALUES(DEFAULT, NOW(), '취소/환불 요청 중', ?, ?, ?, ?, ?, ?)";
	private final String CHANGE_PRODUCT_STATE = "UPDATE order_detail SET product_state = '취소/환불 요청 중' WHERE order_detail_num = ?";

	private final String PRODUCT_CHANGE = "SELECT o.order_num, p.product_name, o.recipient, o.phone_num, o.address, o.detail_address, od.amount, od.order_detail_num"
			+ " FROM orders o" + " JOIN order_detail od ON od.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num" + " WHERE od.order_detail_num = ?";

	private final String PRODUCT_CHANGE_REQ = "INSERT INTO product_refund_or_change VALUES(DEFAULT, NOW(), '교환 요청 중', ?, ?, ?, ?, ?, ?)";
	private final String CHANGE_PRODUCT_STATE2 = "UPDATE order_detail SET product_state = '상품 교환 중' WHERE order_detail_num = ?";
	
	private final String ORDER_SUCC_INFO = "SELECT order_num, order_date, address, detail_address, postal_num, delivery_price, "
			+ "recipient, request, payment, phone_num FROM orders WHERE order_num = ?";
	
	private final String ORDER_SUCC_PRODUCT = 
			"SELECT od.total_price, pc.product_code, ps.size_name, pco.color_name, p.product_price, p.product_name, od.amount" + 
			" FROM orders o" + 
			" JOIN order_detail od ON od.order_num = o.order_num" + 
			" JOIN product_code pc ON pc.product_code = od.product_code" + 
			" JOIN product_size ps ON ps.size_num = pc.size_num" + 
			" JOIN product_color pco ON pco.color_num = ps.color_num" + 
			" JOIN product p ON p.product_num = pco.product_num" + 
			" JOIN product_img pimg ON pimg.product_num = p.product_num" + 
			" WHERE o.order_num = ?";
	
	
	public OrderVO getOrderInfo(OrderVO vo) {
		try {
			System.out.println("getOrderInfo()");
			Object[] args = { vo.getOrder_num() };
			return jdbcTemplate.queryForObject(ORDER_INFO, args, new OrderInfoRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<OrderVO> getOrderList(OrderVO vo) {
		try {
			System.out.println("getOrderList()");
			Object[] args = { vo.getUser_num() };
			return jdbcTemplate.query(ORDER_LIST, args, new OrderListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<OrderVO> getOrderList2(OrderVO vo, int date) {
		try {
			System.out.println("getOrderList2()");
			Object[] args = { vo.getUser_num(), date };
			return jdbcTemplate.query(ORDER_LIST2, args, new OrderListRowMapper());

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public OrderVO getProductOrder(String productCode, int amount) {
		try {
			System.out.println("getProductOrder()");
			Object[] args = { amount, amount, productCode };

			return jdbcTemplate.queryForObject(PRODUCT_ORDER, args, new ProductOrderRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public OrderVO getPoint(int user_num) {
		try {
			System.out.println("getPoint()");
			Object[] args = { user_num };

			return jdbcTemplate.queryForObject(USER_POINT, args, new UserPointRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<OrderVO> getProductOrderFromCart(OrderVO vo) {
		try {
			System.out.println("getProductOrderFromCart()");
			Object[] args = { vo.getUser_num() };

			return jdbcTemplate.query(PRODUCT_ORDER_CART, args, new ProductOrderRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void insertBuyOrder(OrderVO vo) {
		System.out.println("insertBuyOrder()");
		jdbcTemplate.update(BUY_ORDER, vo.getAddress(), vo.getDetail_address(), vo.getPostal_num(),
				vo.getDelivery_price(), vo.getRecipient(), vo.getRequest(), vo.getPayment(), vo.getUser_num(),
				vo.getPhone_num());

		return;
	}
	
	public OrderVO getBuyOrder(OrderVO vo) {
		System.out.println("getBuyOrder()");
		Object[] args = {vo.getAddress(), vo.getDetail_address(), vo.getPostal_num(),
				vo.getDelivery_price(), vo.getRecipient(), vo.getRequest(), vo.getPayment(), vo.getUser_num(),
				vo.getPhone_num()};
		return jdbcTemplate.queryForObject(GET_ORDER, args, new OrderNumRowMapper());

	}

	public void insertBuyOrderDetail(OrderVO vo) {
		System.out.println("insertBuyOrderDetail()");
		jdbcTemplate.update(BUY_ORDER_DETAIL, vo.getAmount(), vo.getAmountMultiPrice(), vo.getOrder_num(),
				vo.getProduct_code());

		return;
	}


	public OrderVO getOrderRefund(OrderVO vo) {
		try {
			System.out.println("getOrderRefund()");
			Object[] args = { vo.getOrder_detail_num() };
			return jdbcTemplate.queryForObject(ORDER_REFUND, args, new OrderRefundRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void insertOrderRefund(OrderVO vo) {

		System.out.println("insertOrderRefund()");

		jdbcTemplate.update(ORDER_REFUND_REQ, vo.getRefund_or_change_reason(), vo.getReason_detail(), vo.getAmount(),
				vo.getBank(), vo.getAccount_num(), vo.getOrder_detail_num());
		return;
	}

	public void updateProduct_state(OrderVO vo) {
		System.out.println("updateProduct_state()");
		jdbcTemplate.update(CHANGE_PRODUCT_STATE, vo.getOrder_detail_num());
		return;
	}

	public OrderVO getProductChange(OrderVO vo) {
		try {
			System.out.println("getProductChange()");
			Object[] args = { vo.getOrder_detail_num() };
			return jdbcTemplate.queryForObject(PRODUCT_CHANGE, args, new ProductChangeRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void insertProductChange(OrderVO vo) {

		System.out.println("insertProductChange()");

		jdbcTemplate.update(PRODUCT_CHANGE_REQ, vo.getRefund_or_change_reason(), vo.getReason_detail(), vo.getAmount(),
				vo.getBank(), vo.getAccount_num(), vo.getOrder_detail_num());
		return;
	}

	public void updateProduct_state2(OrderVO vo) {
		System.out.println("updateProduct_state2()");
		jdbcTemplate.update(CHANGE_PRODUCT_STATE2, vo.getOrder_detail_num());
		return;
	}

	public OrderVO getOrderSuccInfo(OrderVO vo) {
		try {
			System.out.println("getOrderSuccInfo()");
			Object[] args = { vo.getOrder_num() };
			return jdbcTemplate.queryForObject(ORDER_SUCC_INFO, args, new OrderSuccInfoRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<OrderVO> getProductOrderWhenSuccess(OrderVO vo) {
		try {
			System.out.println("getProductOrderWhenSuccess()");
			Object[] args = { vo.getOrder_num()};
			return jdbcTemplate.query(ORDER_SUCC_PRODUCT, args, new OrderSuccProductRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
