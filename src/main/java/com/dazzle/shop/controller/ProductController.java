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
import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.ProductService;

@Controller
@SessionAttributes("product")
public class ProductController {
	
	@Autowired
	private ProductService product_service;

	@RequestMapping(value = "/getProductList.do")
	public String get_category_by_products(Model _model, @RequestParam("category") String _category) {
		
		List<CategoryVO> category = product_service.get_category(_category);
		_model.addAttribute("category",category);
		
		List<ProductVO> product_list = product_service.get_category_by_products(_category);
		_model.addAttribute("product_list", product_list);
		System.out.println(product_list);
		
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
