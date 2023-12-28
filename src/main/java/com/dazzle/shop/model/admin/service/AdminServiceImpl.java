package com.dazzle.shop.model.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.admin.domain.AdminProductVO;
import com.dazzle.shop.model.admin.domain.AdminUserVO;
import com.dazzle.shop.model.admin.domain.SubCategoryVO;
import com.dazzle.shop.model.admin.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	// 테이블 행 개수 출력
	@Override
	public int countTableRecord(String tableName) {

		return adminDAO.getTotalCount(tableName);
	}

	// 서브 카테고리용 레코드 개수 반환
	@Override
	public int countSubCategoryItems(int subCategoryNum) {
		return adminDAO.countSubCategoryItems(subCategoryNum);
	}

	// 블랙리스트인 유저 수 반환
	@Override
	public int countBlacklist() {

		return adminDAO.countBlacklist();
	}

	// 서브카테고리 번호, 이름 출력
	@Override
	public List<SubCategoryVO> getSubCategoryList() {

		return adminDAO.getSubCategoryList();
	}

	/*
	 * 회원 관리
	 */
	/*
	 * 회원 목록
	 */
	@Override
	public List<AdminUserVO> getUserList(int currentPage, int usersPerPage) {
		return adminDAO.getUserList(currentPage, usersPerPage);
	}

	// 블랙리스트 목록
	@Override
	public List<AdminUserVO> getBlackist(int pageSize, int pageNum) {
		return adminDAO.getBlackist(pageSize, pageNum);
	}

	// 상품 관리
	// 상품 목록
	@Override
	public List<AdminProductVO> getProductList(int subCategoryNum, int itemsPerPage, int currentPage) {

		return adminDAO.getProductList(subCategoryNum, itemsPerPage, currentPage);
	}

	// 상품 상세 - 세부 정보
	@Override
	public AdminProductVO getProductDetail(int product_num) {

		return adminDAO.getProductDetail(product_num);
	}

	// 상품 상세 - 색상, 사이즈, 재고
	@Override
	public List<AdminProductVO> getProductStock(int product_num) {

		return adminDAO.getProductStock(product_num);
	}

	// 상품 추가
	// 1단계: 추가하고 product_num 가져오기
	@Override
	public int getProductNum(int subCategoryNum) {
		return adminDAO.getProductNum(subCategoryNum);
	}

	// 2단계: 제품 기본정보 추가
	@Override
	public void updateProductBasicInfo(AdminProductVO vo) {
		adminDAO.updateProductBasicInfo(vo);
	}

	// DB에 이미지 경로 추가
	@Override
	public void insertProductImg(int product_num, String img_name, int img_type) {
		adminDAO.insertProductImg(product_num, img_name, img_type);
	}

	// 3단계: 제품 색상 추가
	@Override
	public int insertProductColor(int product_num, String color_name) {
		return adminDAO.insertProductColor(product_num, color_name);
	}

	// 3단계: 제품 사이즈 및 재고 추가
	@Override
	public void insertProductSize(int color_num, String size_name, int product_stock) {
		adminDAO.insertProductSize(color_num, size_name, product_stock);
	}

	// 상품 수정

	// 상품 활성화
	@Override
	public void activateProduct(int product_num) {
		adminDAO.activateProduct(product_num);
	}

	// 상품 비활성화
	@Override
	public void deactivateProduct(int product_num) {
		adminDAO.deactivateProduct(product_num);
	}

	/*
	 * 주문 관리
	 */
	/*
	 * 주문 목록
	 */
	/*
	 * 배송 목록
	 */
	/*
	 * 취소/환불 요청 목록
	 */
	/*
	 * 반품 요청 목록
	 */

}
