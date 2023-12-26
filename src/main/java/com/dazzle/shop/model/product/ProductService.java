package com.dazzle.shop.model.product;

import java.util.List;

public interface ProductService {
	
	List<ProductVO> get_category_by_products(String _category_num);
	
	List<ProductVO> get_sub_categoy_by_products(String _sub_category_num);
	
	List<CategoryVO> get_category(String _category_num);
	
	List<SubCategoryVO> get_sub_category(String _category_num);
	
}
