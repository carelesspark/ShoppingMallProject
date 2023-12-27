package com.dazzle.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.product.ProductVO;
import com.dazzle.shop.model.product.ProductsVO;
import com.dazzle.shop.model.product.ReviewVO;
import com.dazzle.shop.model.product.SubCategoryVO;
import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.ProductImgVO;
import com.dazzle.shop.model.product.ProductService;
import com.dazzle.shop.model.product.ProductSizeVO;

@Controller
@SessionAttributes("product")
public class ProductController {

	@Autowired
	private ProductService product_service;

	@RequestMapping(value = "/category_products.do")
	public String get_category_by_products(Model _model, @RequestParam("category") String _category_num,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		final int size = 12;

		List<CategoryVO> category = product_service.get_category(_category_num);
		_model.addAttribute("category", category);
		_model.addAttribute("category_num", _category_num);

		List<SubCategoryVO> sub_category = product_service.get_sub_category(_category_num);
		_model.addAttribute("sub_category", sub_category);

		List<ProductsVO> category_products = product_service.get_category_by_products_paged(_category_num, page, size);
		_model.addAttribute("category_products", category_products);

		int totalProducts = product_service.count_category_products(_category_num);
		int totalPages = (int) Math.ceil((double) totalProducts / size);
		_model.addAttribute("totalPages", totalPages);
		_model.addAttribute("currentPage", page);

		_model.addAttribute("selectedCategory", _category_num);
		_model.addAttribute("selectedSubCategory", null);

		return "/product/productList.jsp";
	}

	@RequestMapping(value = "/sub_category_products.do")
	public String get_sub_category_by_products_paged(Model _model, @RequestParam("category") String _category_num,
			@RequestParam("sub_category") String _sub_category_num,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		final int size = 12;

		List<CategoryVO> category = product_service.get_category(_category_num);
		_model.addAttribute("category", category);

		List<SubCategoryVO> sub_category = product_service.get_sub_category(_category_num);
		_model.addAttribute("sub_category", sub_category);

		List<ProductsVO> sub_category_products = product_service.get_sub_category_by_products_paged(_sub_category_num,
				page, size);
		_model.addAttribute("sub_category_products", sub_category_products);
		_model.addAttribute("currentPage", page);

		int totalProducts = product_service.count_sub_category_products(_sub_category_num); //
		int totalPages = (int) Math.ceil((double) totalProducts / size);
		_model.addAttribute("totalPages", totalPages);
		_model.addAttribute("currentPage", page);

		_model.addAttribute("selectedCategory", _category_num);
		_model.addAttribute("selectedSubCategory", _sub_category_num);

		return "/product/productList.jsp";
	}

	@RequestMapping(value = "/search_result.do")
	public String search_result_paged(Model _model, @RequestParam("search_keyword") String _search_keyword,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		final int size = 12;

		String search_keyword = "%" + _search_keyword + "%";
		_model.addAttribute("search_keyword", search_keyword);

		List<ProductsVO> search_products = product_service.search_result_paged(search_keyword, page, size);
		_model.addAttribute("search_products", search_products);

		int totalProducts = product_service.count_search_products(search_keyword);
		int totalPages = (int) Math.ceil((double) totalProducts / size);
		_model.addAttribute("totalPages", totalPages);
		_model.addAttribute("currentPage", page);

		_model.addAttribute("selectedSearchKeyword", _search_keyword);

		return "/product/productList.jsp";
	}

	@RequestMapping(value = "/product.do")
	public String getProduct(Model _model, @RequestParam("product_num") int _product_num) {

		ProductVO product_info = product_service.product_info(_product_num);
		_model.addAttribute("product_info", product_info);

		ProductImgVO product_img = product_service.product_img(_product_num);
		_model.addAttribute("product_img", product_img);

		return "/product/product.jsp";
	}

	@RequestMapping(value = "/review.do")
	public String review(ReviewVO _vo, HttpServletRequest _req, @RequestParam("product_num") int _product_num,
			Model _model) {

		ProductVO product_info = product_service.product_info(_product_num);
		_model.addAttribute("product_info", product_info);

		return "/product/review.jsp";
	}

	@RequestMapping(value = "/submit_review.do")
	public String submitReview(@RequestParam("review_content") String _review_content) {

		return "redirect:/product.do";

	}

	@RequestMapping(value = "/inquiry.do")
	public String getInquiry() {
		return "/product/inquiry.jsp";
	}

	@RequestMapping(value = "/add_to_cart.do")
	public String addToCart(HttpServletRequest _req, Model _model, @RequestParam("size_num") int _size_num,
			@RequestParam("quantity") int _quantity) {

//		Integer session_user_num = (Integer) _req.getSession().getAttribute("user_num");
//
//		if (session_user_num == null) {
//			return "redirect:/sign/sign_in.jsp";
//		}
//		
//		int user_num = session_user_num.intValue();

		System.out.println(_size_num);
		System.out.println(_quantity);

		return null;
	}

	@RequestMapping(value = "/buy_now.do")
	public String buyNow(HttpServletRequest _req, Model _model, @RequestParam("size_num") int _size_num,
			@RequestParam("quantity") int _quantity) {

//		Integer session_user_num = (Integer) _req.getSession().getAttribute("user_num");
//
//		if (session_user_num == null) {
//			return "redirect:/sign/sign_in.jsp";
//		}
		
//		int user_num = session_user_num.intValue();
		
		
		
		System.out.println(_size_num);
		System.out.println(_quantity);

		return null;
	}

}
