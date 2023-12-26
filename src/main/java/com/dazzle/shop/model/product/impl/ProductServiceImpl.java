package com.dazzle.shop.model.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.ProductService;
import com.dazzle.shop.model.product.ProductVO;
import com.dazzle.shop.model.product.SubCategoryVO;

@Service("product_service")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO dao;

	@Override
	public List<ProductVO> get_category_by_products(String _category_num) {
		
		return dao.get_category_by_products(_category_num);
	}
	
	@Override
	public List<ProductVO> get_sub_categoy_by_products(String _sub_category_num) {
		
		return dao.get_sub_category_by_products(_sub_category_num);
	}

	@Override
	public List<CategoryVO> get_category(String _category_num) {
		
		return dao.get_category(_category_num);
	}

	@Override
	public List<SubCategoryVO> get_sub_category(String _category_num) {
		
		return dao.get_sub_category(_category_num);
	}
}
