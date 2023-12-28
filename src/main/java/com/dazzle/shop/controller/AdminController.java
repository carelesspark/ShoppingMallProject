package com.dazzle.shop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dazzle.shop.model.admin.domain.*;
import com.dazzle.shop.model.admin.service.AdminService;
import com.dazzle.shop.model.order.OrderService;
import com.dazzle.shop.model.order.OrderVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private OrderService orderService;

	// 회원 관리
	// 회원 목록
	@GetMapping("/userList.do")
	public String adminUserList(Model model) {
		System.out.println("AdminController: adminUserList");

		int totalItems = adminService.countTableRecord("user_info"); // 유저 총 개수
		System.out.println("total items: " + totalItems);
		int itemsPerPage = 10; // 페이지 당 표시할 레코드 수
		int currentPage = 1; // 현재 페이지
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		List<AdminUserVO> list = adminService.getUserList(currentPage, itemsPerPage);
		model.addAttribute("userList", list);

		return "admin_user_list.jsp";
	}

	// 회원 목록 - 페이지 당 행 개수
	// 회원 목록 - 페이지 이동
	@GetMapping("/changeUserList.do")
	public String changeUserList(@RequestParam("itemsPerPage") int itemsPerPage,
			@RequestParam("currentPage") int currentPage, Model model) {
		System.out.println("AdminController: changeUserList");

		int totalItems = adminService.countTableRecord("user_info"); // 유저 총 개수
		System.out.println("total items: " + totalItems);
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		List<AdminUserVO> list = adminService.getUserList(currentPage, itemsPerPage);
		model.addAttribute("userList", list);

		return "admin_user_list.jsp";
	}

	// 블랙리스트 목록
	@GetMapping("/userBlacklist.do")
	public String userBlacklist(Model model) {
		System.out.println("AdminController: userBlacklist");

		int totalRecordNum = adminService.countBlacklist();
		int pageSize = 10;
		int pageNum = 1;
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalRecordNum / pageSize + 1);

		List<AdminUserVO> list = adminService.getBlackist(pageSize, pageNum);
		model.addAttribute("userList", list);

		return "admin_user_list.jsp";
	}

	// 상품 관리
	// 상품 목록
	@GetMapping("/productList.do")
	public String adminProductList(HttpServletRequest request, Model model) {
		System.out.println("AdminController: adminProductList");

		List<SubCategoryVO> subCategory = adminService.getSubCategoryList();
		model.addAttribute("subCategory", subCategory);
		model.addAttribute("subCategoryNum", 0);
		model.addAttribute("subCategoryStartNum", 0);

		int totalItems = adminService.countSubCategoryItems(1);
		System.out.println("total items: " + totalItems);
		int itemsPerPage = 10;
		int currentPage = 1;
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		int subCategoryNum = 1;
		List<AdminProductVO> list = adminService.getProductList(subCategoryNum, itemsPerPage, currentPage);
		model.addAttribute("productList", list);
		System.out.println("개수: " + list.size());

		return "admin_product_list.jsp";
	}

	// 카테고리 버튼 누르면 그에 맞는 상품 리스트 보여줌
	@GetMapping("/changeProductList.do")
	public String changeProductList(@RequestParam("subCategoryNum") int subCategoryNum,
			@RequestParam("currentPage") int currentPage, @RequestParam("itemsPerPage") int itemsPerPage, Model model) {
		System.out.println("AdminController: changeProductList");

		List<SubCategoryVO> subCategory = adminService.getSubCategoryList();
		model.addAttribute("subCategory", subCategory);
		model.addAttribute("subCategoryNum", subCategoryNum);
		model.addAttribute("subCategoryStartNum", (subCategoryNum / 5) * 5);

		int totalItems = adminService.countSubCategoryItems(subCategoryNum + 1);
		int totalPage = totalItems / itemsPerPage; // 전체 페이지
		if (totalItems % itemsPerPage > 0) {
			totalPage++;
		}
		model.addAttribute("itemsPerPage", itemsPerPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);

		List<AdminProductVO> list = adminService.getProductList(subCategoryNum + 1, itemsPerPage, currentPage);
		model.addAttribute("productList", list);

		return "admin_product_list.jsp";
	}

	@GetMapping("/productDetail.do")
	public String adminProductDetail(@RequestParam("product_num") int product_num, Model model) {
		System.out.println("AdminController: adminProductDetail");

		AdminProductVO productInfo = adminService.getProductDetail(product_num);
		List<AdminProductVO> stockList = adminService.getProductStock(product_num);
		model.addAttribute("productInfo", productInfo);
		model.addAttribute("stockList", stockList);

		return "admin_product_detail.jsp";
	}

	// 상품 추가 페이지로 단순 이동
	@RequestMapping("/goAddProduct.do")
	public String goAddProductPage() {
		System.out.println("AdminController: goAddProduct");

		return "add_product_category.jsp";
	}

	// 상품 추가
	// 1단계: 카테고리에 해당하는 상품을 추가하고 product_num 가져오기
	@GetMapping("/addProduct.do")
	public String addProduct(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("AdminController: addProduct");

		int sub_category_num = Integer.parseInt(request.getParameter("sub_category_num"));

		int product_num = adminService.getProductNum(sub_category_num);
		model.addAttribute("product_num", product_num);

		return "add_product_basic.jsp";
	}

	// 2단계: 상품의 기본 정보 및 이미지 저장
	@PostMapping("/addProductBasicInfo.do")
	public String addProductBasicInfo(MultipartHttpServletRequest mRequest, HttpServletRequest request, Model model) {
		System.out.println("AdminController: addProductBasicInfo");

		int product_num = Integer.parseInt(mRequest.getParameter("product_num"));
		String product_name = mRequest.getParameter("product_name");
		String product_info = mRequest.getParameter("product_info");
		int product_price = Integer.parseInt(mRequest.getParameter("product_price"));
		List<MultipartFile> mainImageList = mRequest.getFiles("mainImage");
		MultipartFile thumbnailImage = mRequest.getFile("thumbnailImage");

		String metaPath = request.getSession().getServletContext().getRealPath("/");
		Path currentPath = Paths.get(metaPath);
		Path webappPath = currentPath.getParent();
		for (int i = 0; i < 5; i++) {
			webappPath = webappPath.getParent();
		}

		String imagePath = webappPath + "/ShoppingMallProject/src/main/webapp/resources/image/product/" + product_num
				+ "/";

		// 먼저, product_num으로 상품 정보 수정함
		AdminProductVO vo = new AdminProductVO();
		vo.setProduct_num(product_num);
		vo.setProduct_name(product_name);
		vo.setProduct_info(product_info);
		vo.setProduct_price(product_price);

		adminService.updateProductBasicInfo(vo);

		if (mainImageList.get(0).getSize() == 0 && thumbnailImage.getSize() == 0) { // 비어있다면
			System.out.println("이미지가 입력되지 않음");
		} else { // 비어있지 않다면
			// 메인 이미지 저장 및 DB에 기록
			File directory = new File(imagePath);
			if (!directory.exists()) {
				directory.mkdirs(); // Create the directory if it doesn't exist
			}
			System.out.println("Image Directory: " + directory.getAbsolutePath());

			for (MultipartFile mainImage : mainImageList) {
				String mainImageName = mainImage.getOriginalFilename();
				String filePath = imagePath + mainImageName;

				System.out.println("Main Image Path: " + filePath);

				try {
					mainImage.transferTo(new File(filePath));
					System.out.println("Main image saved successfully");
				} catch (IllegalStateException | IOException e) {
					System.err.println("Error saving main file: " + e.getMessage());
					e.printStackTrace();
				}

				adminService.insertProductImg(product_num, mainImageName, 0);
			}

			// 썸네일 이미지 저장 및 DB에 기록
			String thumbnailImageName = thumbnailImage.getOriginalFilename();
			String thumbnailImagePath = imagePath + thumbnailImageName;

			System.out.println("Thumbnail Image Path: " + thumbnailImagePath);

			try {
				thumbnailImage.transferTo(new File(thumbnailImagePath));
				System.out.println("Thumbnail image saved successfully: " + thumbnailImagePath);
			} catch (IllegalStateException | IOException e) {
				System.err.println("Error saving thumbnail file: " + e.getMessage());
				e.printStackTrace();
			}

			adminService.insertProductImg(product_num, thumbnailImageName, 2);
		}

		model.addAttribute("product_num", product_num);

		return "add_product_remain.jsp";
	}

	// 3단계: 상품의 색상, 사이즈, 재고 저장
	@GetMapping("/addProductRemainInfo.do")
	public String addProductRemainInfo(@RequestParam(name = "product_num") int product_num,
			@RequestParam(name = "color_name[]", required = true) List<String> colorNames,
			@RequestParam(name = "size_name[]", required = true) List<String> sizeNames,
			@RequestParam(name = "product_stock") int product_stock, Model model) {
		System.out.println("AdminController: addProductRemainInfo");

		// 각 색상을 product_color 테이블에 저장
		for (String color_name : colorNames) {
			int color_num = adminService.insertProductColor(product_num, color_name);
			for (String size_name : sizeNames) {
				int size_num = adminService.insertProductSize(color_num, size_name, product_stock);
				adminService.insertProductCode(size_num);
			}
		}

		return "/admin/productList.do";
	}

	// 상품 수정

	// 상품 활성화
	@GetMapping("/activateProduct.do")
	public String activateProduct(@RequestParam("product_num") int product_num, Model modeㅣ, Model model) {
		System.out.println("AdminController: activateProduct");

		adminService.activateProduct(product_num);
		model.addAttribute("product_num", product_num);

		return "productDetail.do";
	}

	// 상품 비활성화
	@GetMapping("/deactivateProduct.do")
	public String deactivateProduct(@RequestParam("product_num") int product_num, Model model) {
		System.out.println("AdminController: deactivateProduct");

		adminService.deactivateProduct(product_num);
		model.addAttribute("product_num", product_num);

		return "productDetail.do";
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/orderListAdmin.do")
	public String getOrderListAdmin(OrderVO vo, Model model) throws Exception {
		System.out.println("관리자 주문 목록 조회");
		List<OrderVO> productStateList = orderService.getProductState();
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		if (vo.getProduct_state() != null && vo.getProduct_state() != "") {
			orderList = orderService.getOrderListAdminState(vo);
			model.addAttribute("product_state", vo.getProduct_state());
		} else if (vo.getProduct_name() != null) {
			orderList = orderService.getOrderListAdminPName(vo);
		} else {
			orderList = orderService.getOrderListAdmin();
		}

		model.addAttribute("orderList", orderList);
		model.addAttribute("productStateList", productStateList);
		return "/admin/orderListAdmin.jsp";
	}

	@RequestMapping(value = "/orderRefundOrChange.do")
	public String getRefundList(OrderVO vo, Model model) throws Exception {
		System.out.println("환불/교환 요청 조회");
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		if (vo.getProduct_name() != null) {
			orderList = orderService.getRefundListPName(vo);
		} else if (vo.getApprove_search() == 1 && vo.getApprove() != 2) {
			orderList = orderService.getRefundListApprove(vo);
			model.addAttribute("approve", vo.getApprove());
		} else {
			orderList = orderService.getRefundList();
		}

		model.addAttribute("orderList", orderList);

		return "/admin/orderRefundOrChange.jsp";

	}

	@RequestMapping(value = "/orderInfoAdmin.do")
	public String getOrderInfoAdmin(OrderVO vo, Model model) throws Exception {

		System.out.println("글 상세 조회 처리(관리자)");
		OrderVO orderInfo = orderService.getOrderDetailInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/admin/orderInfoAdmin.jsp";
	}

	@GetMapping(value = "/orderInfoEdit.do")
	public String getOrderInfoEditGet(OrderVO vo, Model model) throws Exception {

		System.out.println("글 수정 조회");
		OrderVO orderInfo = orderService.getOrderDetailInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/admin/orderInfoEdit.jsp";
	}

	@PostMapping(value = "/orderInfoEdit.do")
	public String getOrderInfoEditPost(OrderVO vo, Model model) throws Exception {
		System.out.println(vo);
		System.out.println("글 수정");

		orderService.updateOrderState(vo);
		orderService.updateOrderDelv(vo);

		return "redirect:orderInfoAdmin.do?order_detail_num=" + vo.getOrder_detail_num();
	}

	@RequestMapping(value = "/orderRefundInfo.do")
	public String orderRefundInfo(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 조회");
		OrderVO orderInfo = orderService.getRefundInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/admin/orderRefundInfo.jsp";
	}

	@GetMapping(value = "/orderRefundAccept.do")
	public String orderRefundAcceptGet(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 승인 페이지");
		OrderVO orderInfo = orderService.getRefundInfo(vo);
		model.addAttribute("orderInfo", orderInfo);

		return "/admin/orderRefundAccept.jsp";
	}

	@PostMapping(value = "/orderRefundAccept.do")
	public String orderRefundAcceptPost(OrderVO vo, Model model) throws Exception {

		System.out.println("취소/환불 승인");
		orderService.approveRequest(vo);
		String refund_or_change = "";
		if (vo.getChange() == 1)
			refund_or_change += "교환";
		else if (vo.getCancel() == 1)
			refund_or_change += "환불";

		if (vo.getApprove() == 1)
			refund_or_change += " 승인";
		else if (vo.getApprove() == -1)
			refund_or_change += " 거절";

		System.out.println(refund_or_change);
		vo.setProduct_state(refund_or_change);
		orderService.updateOrderState(vo);

		return "redirect:orderRefundInfo.do?refund_change_num=" + vo.getRefund_change_num();
	}

}
