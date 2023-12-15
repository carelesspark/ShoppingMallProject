package com.dazzle.shop.model.order.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.order.OrderListVO;

@Repository
public class OrderDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String ORDER_LIST = "SELECT o.order_num, od.product_state, d.delivery_date, p.product_name, p.product_price"
			+ " FROM orders o"
			+ " JOIN order_detail od ON o.order_num = od.order_num"
			+ " JOIN delivery d ON d.order_num = o.order_num"
			+ " JOIN product_code pc ON pc.product_code = od.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num";

	public List<OrderListVO> getOrderList(OrderListVO vo){
		List<OrderListVO> orderList = new ArrayList();
		
		System.out.println("=> getOrderList() 기능 처리");
		
		return jdbcTemplate.query(ORDER_LIST, new OrderRowMapper());
	}
}
