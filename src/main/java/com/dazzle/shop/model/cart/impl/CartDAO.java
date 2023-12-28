package com.dazzle.shop.model.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.cart.CartVO;

@Repository
public class CartDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String CART_LIST = "SELECT c.cart_num, c.user_num, pimg.img_name, c.product_code, p.product_price, (p.product_price * c.amount) AS total_price, c.amount, p.product_name, pco.color_name, ps.size_name"
			+ " FROM cart c" + " JOIN users u ON u.user_num = c.user_num"
			+ " JOIN user_info ui ON ui.user_num = u.user_num"
			+ " JOIN product_code pc ON pc.product_code = c.product_code"
			+ " JOIN product_size ps ON ps.size_num = pc.size_num"
			+ " JOIN product_color pco ON pco.color_num = ps.color_num"
			+ " JOIN product p ON p.product_num = pco.product_num"
			+ " JOIN product_img pimg ON pimg.product_num = p.product_num" + " WHERE c.user_num = ? AND pimg.img_type = 2";

	private final String CART_DELETE = "delete from cart where cart_num = ?";
	
	private final String CART_DELETE_ALL = "delete from cart where user_num = ?";

	public List<CartVO> getCartList(int user_num) {
		try {
			System.out.println("getCartList()");
			Object[] args = { user_num };

			return jdbcTemplate.query(CART_LIST, args, new CartRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void deleteCart(int cart_num) {

		System.out.println("deleteCart()");

		jdbcTemplate.update(CART_DELETE, cart_num);

		return;

	}
	
	public void deleteCartAll(int user_num) {

		System.out.println("deleteCartAll()");

		jdbcTemplate.update(CART_DELETE_ALL, user_num);

		return;

	}
}
