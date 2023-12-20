package com.dazzle.shop.model.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.ProductVO;

@Repository("product_dao")
public class ProductDAO {

	@Autowired
	private JdbcTemplate jdbc_template;

	private final String get_category_by_products = "SELECT * FROM product p "
			+ "JOIN sub_category s on p.sub_category_num = s.sub_category_num "
			+ "JOIN category c ON s.category_num = c.category_num "
			+ "WHERE c.category_name = ?";

	private final String get_category = "SELECT * FROM category c "
			+ "JOIN sub_category s ON c.category_num = s.category_num "
			+ "WHERE c.category_name = ?";

	public List<ProductVO> get_category_by_products(String _category) {
		System.out.println("카테고리 별 상품목록 조회");
		return jdbc_template.query(get_category_by_products, new Object[] { _category }, new ProductRowMapper());
	}

	public List<CategoryVO> get_category(String _category) {
		System.err.println("카테고리 조회");
		return jdbc_template.query(get_category, new Object[] { _category }, new CategoryRowMapper());
	}
}
