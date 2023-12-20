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

	private final String ORDER_LIST = "SELECT o.order_num, od.product_state, o.order_date, p.product_name, p.product_price"
			+ " FROM orders o" + " JOIN order_detail od ON o.order_num = od.order_num"
			+ " JOIN delivery d ON d.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num"
			+ " WHERE o.user_num = ?";

	private final String ORDER_INFO = "SELECT o.order_num, ps.size_name, pco.color_name, od.amount, p.product_price, p.product_name, od.product_state, d.delivery_date, d.delivery_company, d.invoice_num, o.recipient, o.address, o.detail_address, o.phone_num, o.request"
			+ " FROM orders o" + " JOIN order_detail od ON o.order_num = od.order_num"
			+ " JOIN delivery d ON d.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num" + " WHERE o.order_num = ?;";

	private final String PRODUCT_ORDER = "SELECT pimg.main_img, (p.product_price * ?) AS total_price, ? AS amount, p.product_name, pco.color_name, ps.size_name, ui.user_point"
			+ " FROM cart c\r\n" + " JOIN users u ON u.user_num = c.user_num"
			+ " JOIN user_info ui ON ui.user_num = u.user_num"
			+ " JOIN product_code pc ON pc.product_code = c.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num"
			+ " JOIN product_img pimg ON pimg.product_num = p.product_num"
			+ " WHERE pc.product_code = ? AND u.user_num = ?";

	private final String PRODUCT_ORDER_CART = "SELECT pimg.main_img, (p.product_price * c.amount) AS total_price, c.amount, p.product_name, pco.color_name, ps.size_name, ui.user_point"
			+ " FROM cart c" + " JOIN users u ON u.user_num = c.user_num"
			+ " JOIN user_info ui ON ui.user_num = u.user_num"
			+ " JOIN product_code pc ON pc.product_code = c.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num"
			+ " JOIN product_img pimg ON pimg.product_num = p.product_num" + " WHERE c.user_num = ?";

	private final String BUY_ORDER = "INSERT INTO orders VALUES (DEFAULT, NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String BUY_ORDER_DETAIL = "INSERT INTO order_detail VALUES(DEFAULT, '상품 준비 중', ?, ?, ?, ?)";
	
	private final String SUCCESS_ORDER = "SELECT pimg.main_img, (p.product_price * ? ) AS total_price, ? AS amount, p.product_name, pco.color_name, ps.size_name, o.order_num, o.order_date, o.delivery_price" + 
			" FROM orders o" + 
			" JOIN users u ON u.user_num = o.user_num" + 
			" JOIN order_detail od ON od.order_num = o.order_num" + 
			" JOIN product_code pc ON pc.product_code = od.product_code" + 
			" JOIN product_size ps ON ps.size_num = pc.size_num" + 
			" JOIN product_color pco ON pco.color_num = ps.color_num" + 
			" JOIN product p ON p.product_num = pco.product_num" + 
			" JOIN product_img pimg ON pimg.product_num = p.product_num" + 
			" WHERE u.user_num = ?";

	public OrderVO getOrderInfo(OrderVO vo) {
		System.out.println("getOrderInfo()");
		Object[] args = { vo.getUser_num() };
		return jdbcTemplate.queryForObject(ORDER_INFO, args, new OrderInfoRowMapper());
	}

	public List<OrderVO> getOrderList(OrderVO vo) {
		System.out.println("getOrderList()");
		Object[] args = { vo.getOrder_num() };

		return jdbcTemplate.query(ORDER_LIST, args, new OrderListRowMapper());
	}

	public List<OrderVO> getProductOrder(int userNum, String productCode, int amount, OrderVO vo) {
		try {
			System.out.println("getProductOrder()");
			Object[] args = { amount, amount, productCode, userNum };

			return jdbcTemplate.query(PRODUCT_ORDER, args, new ProductOrderRowMapper());
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
		jdbcTemplate.update(BUY_ORDER, vo.getAddress(), vo.getDetail_address(), vo.getPostal_num(), vo.getDelivery_price(), vo.getRecipient(), vo.getRequest(), vo.getPayment(), vo.getUser_num(), vo.getPhone_num());

		return;
	}
	
	public void insertBuyOrderDetail(OrderVO vo) {
		System.out.println("insertBuyOrderDetail()");
		jdbcTemplate.update(BUY_ORDER_DETAIL, vo.getAmount(), vo.getAmountMultiPrice(), vo.getOrder_num(), vo.getProduct_code());

		
		return;
	}
	
	public List<OrderVO> getProductOrderWhenSuccess(OrderVO vo) {
		try {
			System.out.println("getProductOrderWhenSuccess()");
			Object[] args = { vo.getAmount(), vo.getAmount(), vo.getUser_num() };

			return jdbcTemplate.query(SUCCESS_ORDER, args, new SuccessPageRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
}
