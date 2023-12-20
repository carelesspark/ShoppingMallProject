package com.dazzle.shop.model.cart.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
}
