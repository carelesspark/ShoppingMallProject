package com.dazzle.shop.model.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.cart.CartVO;
import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.InquiryVO;
import com.dazzle.shop.model.product.PageVO;
import com.dazzle.shop.model.product.ProductCodeVO;
import com.dazzle.shop.model.product.ProductColorVO;
import com.dazzle.shop.model.product.ProductImgVO;
import com.dazzle.shop.model.product.ProductService;
import com.dazzle.shop.model.product.ProductSizeVO;
import com.dazzle.shop.model.product.ProductVO;
import com.dazzle.shop.model.product.ProductsVO;
import com.dazzle.shop.model.product.ReviewVO;
import com.dazzle.shop.model.product.SubCategoryVO;

@Service("product_service")
public class ProductServiceImpl implements ProductService{

	


	
	@Autowired
	private ProductDAO dao;

//	@Override
//	public List<ProductsVO> get_category_by_products(String _category_num) {
//		
//		return dao.get_category_by_products(_category_num);
//	}
	
//	@Override
//	public List<ProductsVO> get_sub_categoy_by_products(String _sub_category_num) {
//		
//		return dao.get_sub_category_by_products(_sub_category_num);
//	}

	@Override
	public List<CategoryVO> get_category(String _category_num) {
		
		return dao.get_category(_category_num);
	}

	@Override
	public List<SubCategoryVO> get_sub_category(String _category_num) {
		
		return dao.get_sub_category(_category_num);
	}

//	@Override
//	public List<ProductsVO> search_result(String _product_name) {
//		
//		return dao.search_result(_product_name);
//	}

	@Override
	public List<ProductColorVO> product_colors(int _product_num) {
		
		return dao.product_colors(_product_num);
	}

	@Override
	public ProductVO product_info(int _product_num) {
		
		return dao.product_info(_product_num);
	}

	@Override
	public List<ProductSizeVO> product_sizes(int _color_num) {
		
		return dao.product_sizes(_color_num);
	}

	@Override
	public ProductImgVO product_img(int _product_num) {
		
		return dao.product_img(_product_num);
	}
	
	@Override
	public List<ProductsVO> get_category_by_products_paged(String _category_num, int page, int size) {
	    int offset = (page - 1) * size;
	    return dao.get_category_by_products_paged(_category_num, size, offset);
	}
	
	@Override
	public int count_category_products(String _category_num) {
	    return dao.count_category_products(_category_num);
	}

	@Override
	public List<ProductsVO> get_sub_category_by_products_paged(String _sub_category_num, int page, int size) {
	    int offset = (page - 1) * size;
	    return dao.get_sub_category_by_products_paged(_sub_category_num, size, offset);
	}
	
	@Override
	public int count_sub_category_products(String _sub_category_num) {
		return dao.count_sub_category_products(_sub_category_num);
	}

	@Override
	public List<ProductsVO> search_result_paged(String _search_keyword, int page, int size) {
	    int offset = (page - 1) * size;
	    return dao.search_result_paged(_search_keyword, size, offset);
	}

	@Override
	public int count_search_products(String _search_keyword) {
		return dao.count_search_products(_search_keyword);
	}


	@Override
	public ProductCodeVO get_product_code(int _size_num) {
		return dao.get_product_code(_size_num);
	}

	@Override
	public void insert_cart(int _user_num, int _product_code, int _amount) {	
		dao.insert_cart(_user_num, _product_code, _amount);
	}
  
	@Override
	public List<ReviewVO> getReview(Integer product_num, Integer start, Integer end){
		return dao.getReview(product_num, start, end);
	}
	@Override
	public List<ReviewVO> getReviewSome(ReviewVO vo){
		return dao.getReviewSome(vo);
	}
	@Override
	public ReviewVO getReviewCount(ReviewVO vo) {
		return dao.getReviewCount(vo);
	}

	
	@Override
	public void insertInquiry(InquiryVO vo) {
		
		dao.insertInquiry(vo);
	}

	@Override
	public List<InquiryVO> getInquiry(int _product_num, int a, int b) {
		
		return dao.getInquiry(_product_num, a, b);

	}

	@Override
	public InquiryVO getInquiryCount(int _product_num) {
		
		return dao.getInquiryCount(_product_num);
	}
	@Override
	public void insertReview(ReviewVO vo) {
		dao.insertReview(vo);
	}
	@Override
	public ReviewVO getReviewOne(ReviewVO vo) {
		return dao.getReviewOne(vo);
	}
	@Override
	public void insertReviewImg(ReviewVO vo) {
		dao.insertReviewImg(vo);
	}
	
	@Override
	public CartVO compareCart(CartVO vo) {
		
		return dao.compareCart(vo);
	}
}
