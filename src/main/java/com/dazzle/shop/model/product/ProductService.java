package com.dazzle.shop.model.product;

import java.util.List;

public interface ProductService {
	
	List<ProductVO> get_category_by_products(String _category);
	
	List<CategoryVO> get_category(String _category);
}
