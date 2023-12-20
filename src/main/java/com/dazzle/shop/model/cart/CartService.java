package com.dazzle.shop.model.cart;

import java.util.List;

public interface CartService {
	
	List<CartVO> getCart(CartVO vo);
}
