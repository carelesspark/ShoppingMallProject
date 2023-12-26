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
	 * 매출 관리
	 */
	/*
	 * 매출 목록
	 */
	/*
	 * 가계부
	 */

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

	/*
	 * 상품 관리
	 */
	/*
	 * 상품 목록
	 */
	@Override
	public List<AdminProductVO> getProductList(int subCategoryNum, int pageSize, int pageNum) {

		return adminDAO.getProductList(subCategoryNum, pageSize, pageNum);
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

	/*
	 * 상품 추가
	 */
	/*
	 * 상품 수정
	 */
	/*
	 * 상품 삭제
	 */

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
