package com.dazzle.shop.model.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.cart.CartService;
import com.dazzle.shop.model.cart.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;

	@Override
	public List<CartVO> getCart(CartVO vo) {
		
		return null;
	}
	
}
