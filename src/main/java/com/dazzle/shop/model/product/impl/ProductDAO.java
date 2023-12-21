package com.dazzle.shop.model.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.ProductVO;
import com.dazzle.shop.model.product.SubCategoryVO;

@Repository("product_dao")
public class ProductDAO {

	@Autowired
	private JdbcTemplate jdbc_template;

	private final String get_category_by_products = "SELECT * FROM product p "
			+ "JOIN sub_category s on p.sub_category_num = s.sub_category_num "
			+ "JOIN category c ON s.category_num = c.category_num "
			+ "WHERE c.category_num = ?";
	
	private final String get_sub_category_by_products = "SELECT * FROM product p "
			+ "WHERE p.sub_category_num = ?";
	
	private final String get_category = "SELECT * FROM category c "
			+ "WHERE c.category_num = ?";

	private final String get_sub_category = "SELECT * FROM sub_category s "
			+ "WHERE s.category_num = ?";

	public List<ProductVO> get_category_by_products(String _category_num) {
		System.out.println("카테고리 별 상품목록 조회");
		return jdbc_template.query(get_category_by_products, new Object[] { _category_num }, new ProductRowMapper());
	}
	
	public List<ProductVO> get_sub_category_by_products(String _sub_category_num) {
		System.out.println("서브 카테고리 별 상품목록 조회");
		return jdbc_template.query(get_sub_category_by_products, new Object[] {_sub_category_num}, new ProductRowMapper());
	}

	public List<CategoryVO> get_category(String _category_num) {
		System.out.println("카테고리");
		return jdbc_template.query(get_category, new Object[] { _category_num }, new CategoryRowMapper());
	}
	
	public List<SubCategoryVO> get_sub_category(String _category_num) {
		System.out.println("서브 카테고리");
		return jdbc_template.query(get_sub_category, new Object[] {_category_num }, new SubCategoryMapper());
	}
}
