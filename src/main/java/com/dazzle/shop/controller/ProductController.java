package com.dazzle.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.product.ProductVO;
import com.dazzle.shop.model.product.SubCategoryVO;
import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.ProductService;

@Controller
@SessionAttributes("product")
public class ProductController {

	@Autowired
	private ProductService product_service;

	@RequestMapping(value = "/category_products.do")
	public String get_category_by_products(Model _model, @RequestParam("category") String _category_num) {

		List<CategoryVO> category = product_service.get_category(_category_num);
		_model.addAttribute("category", category);

		List<SubCategoryVO> sub_category = product_service.get_sub_category(_category_num);
		_model.addAttribute("sub_category", sub_category);

		List<ProductVO> category_products = product_service.get_category_by_products(_category_num);
		_model.addAttribute("category_products", category_products);



		return "/product/productList.jsp";
	}
	
	@RequestMapping(value = "/sub_category_products.do")
	public String get_sub_category_by_products(Model _model, @RequestParam("category") String _category_num, @RequestParam("sub_category") String _sub_category_num) {
		
		List<CategoryVO> category = product_service.get_category(_category_num);
		_model.addAttribute("category", category);

		List<SubCategoryVO> sub_category = product_service.get_sub_category(_category_num);
		_model.addAttribute("sub_category", sub_category);
		
		List<ProductVO> sub_category_products = product_service.get_sub_categoy_by_products(_sub_category_num);
		_model.addAttribute("sub_category_products", sub_category_products);
		
		return "/product/productList.jsp";
	}

	@RequestMapping(value = "/product.do")
	public String getProduct() {
		return "/product/product.jsp";
	}

	@RequestMapping(value = "/review.do")
	public String getReview() {
		return "/product/review.jsp";
	}

	@RequestMapping(value = "/inquiry.do")
	public String getInquiry() {
		return "/product/inquiry.jsp";
	}
}
