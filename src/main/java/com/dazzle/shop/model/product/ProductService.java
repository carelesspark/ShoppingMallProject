package com.dazzle.shop.model.product;

import java.util.List;

import com.dazzle.shop.model.cart.CartVO;

public interface ProductService {
	
//	List<ProductsVO> get_category_by_products(String _category_num);
	
//	List<ProductsVO> get_sub_categoy_by_products(String _sub_category_num);
	
	List<CategoryVO> get_category(String _category_num);
	
	List<SubCategoryVO> get_sub_category(String _category_num);
	
//	List<ProductsVO> search_result(String _product_name);
	
	ProductVO product_info(int _product_num);
	
	List<ProductColorVO> product_colors(int _product_num);
	
	List<ProductSizeVO> product_sizes(int _color_num);
	
	ProductImgVO product_img(int _product_num);

	List<ProductsVO> get_category_by_products_paged(String _category_num, int page, int size);
	
	int count_category_products(String _category_num);
	
	List<ProductsVO> get_sub_category_by_products_paged(String _sub_category_num, int page, int size);
	
	int count_sub_category_products(String _sub_category_num);
	
	List<ProductsVO> search_result_paged(String _search_keyword, int page, int size);
	
	int count_search_products(String _search_keyword);
	
	ProductCodeVO get_product_code(int _size_num);
	
	void insert_cart(int _user_num, int _product_code, int _amount);

	List<ReviewVO> getReview(Integer product_num, Integer start, Integer end);
	List<ReviewVO> getReviewSome(ReviewVO vo);
	ReviewVO getReviewCount(ReviewVO vo);

	void insertInquiry(InquiryVO vo);
	
	List<InquiryVO> getInquiry(int _product_num, int a, int b);

	
	InquiryVO getInquiryCount(int _product_num);

	void insertReview(ReviewVO vo);
	ReviewVO getReviewOne(ReviewVO vo);
	void insertReviewImg(ReviewVO vo);
	
	CartVO compareCart(CartVO vo);

}
