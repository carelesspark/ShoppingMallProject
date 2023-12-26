package com.dazzle.shop.model.cart;

import java.util.List;

public interface CartService {
	
	List<CartVO> getCart(int user_num);
	
	void deleteCart(int cart_num);
	
	void deleteCartAll(int user_num);
}
