package com.dazzle.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dazzle.shop.model.product.ProductVO;
import com.dazzle.shop.model.product.ProductsVO;
import com.dazzle.shop.model.product.ReviewVO;
import com.dazzle.shop.model.product.SubCategoryVO;
import com.sun.net.httpserver.Authenticator.Success;
import com.dazzle.shop.model.order.impl.ProductOrderRowMapper;
import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.ProductCodeVO;
import com.dazzle.shop.model.admin.domain.AdminProductVO;
import com.dazzle.shop.model.faq.FaqVO;
import com.dazzle.shop.model.product.InquiryVO;
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
	public String getProduct(Model _model, @RequestParam("product_num") int _product_num, Integer curr_page, Integer curr_inq_page) {


		ProductVO product_info = product_service.product_info(_product_num);
		_model.addAttribute("product_info", product_info);

		ProductImgVO product_img = product_service.product_img(_product_num);
		_model.addAttribute("product_img", product_img);

		
		ReviewVO vo = new ReviewVO();
		vo.setProduct_num(_product_num);
		Integer pageSize = 3;
		
		if(curr_page == null) {
			curr_page = 1;
		}
		Integer reviewCount = 0;
		ReviewVO count = product_service.getReviewCount(vo);
		_model.addAttribute("count", count);
		reviewCount = count.getCount();
		
		int total_pages = 0;
		Integer remain = 0 ;
		List<ReviewVO> review = new ArrayList();
		
		remain = reviewCount - (pageSize * (curr_page - 1));
		review = product_service.getReview(_product_num, Math.min(remain, pageSize), (curr_page-1)*pageSize);

		total_pages = (int)Math.ceil((double) reviewCount / pageSize);
		_model.addAttribute("totalPages", total_pages);
		_model.addAttribute("curr_page", curr_page);
		_model.addAttribute("review", review);
		
		InquiryVO vo2 = new InquiryVO();
		
		if(curr_inq_page == null) {
			curr_inq_page = 1;
		}

		InquiryVO inquiryCount = product_service.getInquiryCount(_product_num);
		_model.addAttribute("inquiryCount", inquiryCount);
		
		
		int total_inquiry_pages = 0;
		Integer inquiry_remain = 0;
		
		inquiry_remain = inquiryCount.getTotal_inquiry() - (pageSize * (curr_inq_page - 1));
		List<InquiryVO> inquiryList = product_service.getInquiry(_product_num, Math.min(inquiry_remain, pageSize), (curr_inq_page-1)*pageSize);
		
		total_inquiry_pages = (int)Math.ceil((double) inquiryCount.getTotal_inquiry() / pageSize);
		_model.addAttribute("totalInquiryPages", total_inquiry_pages);
		_model.addAttribute("curr_inq_page", curr_inq_page);

		
		_model.addAttribute("inquiryList", inquiryList);
		

		return "/product/product.jsp";
	}

	@RequestMapping(value = "/review.do")
	public String review(ReviewVO _vo, HttpServletRequest _req, Model _model) {

		/*
		 * ProductVO product_info = product_service.product_info(_vo.getProduct_code());
		 * _model.addAttribute("product_info", product_info);
		 */
		_model.addAttribute("product_code",_vo.getProduct_code());
		_model.addAttribute("user_num", _req.getSession().getAttribute("user_num"));
		return "/product/review.jsp";
	}

	@RequestMapping(value = "/submit_review.do")
	public String submitReview(MultipartHttpServletRequest img, HttpSession session, ReviewVO vo, Model model) {
		System.out.println(vo);
		String webappPath = session.getServletContext().getRealPath("/");
		System.out.println("webapp path: " + webappPath);
		String imagePath = webappPath + "resources/image/review/" + vo.getProduct_code() + "/";

		System.out.println("Default Path: " + imagePath);

		File directory = new File(imagePath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		System.out.println("Image Directory: " + directory.getAbsolutePath());
		MultipartFile mainImageFile = img.getFile("review_img2");

		if (mainImageFile != null) {
		    String mainImageName = mainImageFile.getOriginalFilename();
		    String filePath = imagePath + mainImageName;
		    System.out.println("Main Image Path: "	+ filePath);
		    try {
		    	mainImageFile.transferTo(new File(filePath));
				System.out.println("Main image saved successfully: " + filePath);
			} catch (IllegalStateException | IOException e) {
				System.err.println("Error saving main file: " + e.getMessage());
				e.printStackTrace();
			}
		    System.out.println(mainImageName);
		    vo.setUser_num((int) session.getAttribute("user_num"));
			product_service.insertReview(vo);
			ReviewVO num = product_service.getReviewOne(vo);
			
			num.setReview_img(mainImageName); 
			product_service.insertReviewImg(num);
			
			return "redirect:/user/orderList.do";
		}else {
			vo.setUser_num((int) session.getAttribute("user_num"));
			product_service.insertReview(vo);
			return "redirect:/user/orderList.do";
		}
		
		
		

	}
	
	

	@RequestMapping(value = "/inquiry.do")
	public String getInquiry(HttpServletRequest request, @RequestParam(name = "product_num") int productNum, Model model) {
		
		HttpSession session = request.getSession();
		Integer user_num = (Integer) session.getAttribute("user_num");
		
		
		if(user_num == null) {
			model.addAttribute("message", "회원에게만 접근 가능한 페이지입니다.");
			model.addAttribute("url", "/sign/login.jsp");
			
			return "/user/user_alert.jsp";
		}
		
		model.addAttribute("user_num", user_num);
		model.addAttribute("product_num", productNum);
		return "/product/inquiry.jsp";
	}
	
	@RequestMapping(value = "/insertInquiry.do")
	public String insertInquiry(HttpServletRequest request, InquiryVO vo) {
		HttpSession session = request.getSession();
		int user_num = (int)session.getAttribute("user_num");
		vo.setUser_num(user_num);
		product_service.insertInquiry(vo);
		
		return "redirect:/product.do?product_num=" + vo.getProduct_num();
	}

	@RequestMapping(value = "/add_to_cart.do")
	@ResponseBody
	public String addToCart(HttpServletRequest _req, 
	                        @RequestParam("size_num") int _size_num, @RequestParam("quantity") int _amount) {
		
		if (_req.getSession().getAttribute("user_num") == null) {
			return "error";
		}
		
		int user_num = (int) _req.getSession().getAttribute("user_num");

	    ProductCodeVO vo = product_service.get_product_code(_size_num);
	    int product_code = vo.getProduct_code();
	    
	    product_service.insert_cart(user_num, product_code, _amount);

	    return "success";
	}

	@RequestMapping(value = "/buy_now.do")
	@ResponseBody
	public String buyNow(RedirectAttributes redirectAttributes, HttpServletRequest _req, Model _model, @RequestParam("size_num") int _size_num,
			@RequestParam("quantity") int _amount) {

		if (_req.getSession().getAttribute("user_num") == null) {
			return "error";
		}
		
		
		ProductCodeVO vo = product_service.get_product_code(_size_num);
		int product_code = vo.getProduct_code();
		
		System.out.println(_amount);
		System.out.println(product_code);
		
//		redirectAttributes.addAttribute("amount", _amount);
//	    redirectAttributes.addAttribute("product_code", product_code);

		return "success";
	}

}
