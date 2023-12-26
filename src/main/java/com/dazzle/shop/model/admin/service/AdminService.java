package com.dazzle.shop.model.admin.service;

import java.util.List;

import com.dazzle.shop.model.admin.domain.*;

public interface AdminService {

	// 테이블 행 개수 출력
	int countTableRecord(String tableName);

	// 블랙리스트인 유저 수 반환
	int countBlacklist();

	// 서브카테고리 번호, 이름 출력
	List<SubCategoryVO> getSubCategoryList();
	/*
	 * 매출 관리
	 */
	/*
	 * 매출 목록
	 */
	/*
	 * 가계부
	 */

	// 회원 관리
	// 회원 목록
	List<AdminUserVO> getUserList(int currentPage, int usersPerPage);

	// 블랙리스트 목록
	List<AdminUserVO> getBlackist(int pageSize, int pageNum);

	// 상품 관리
	// 상품 목록
	List<AdminProductVO> getProductList(int subCategoryNum, int pageSize, int pageNum);

	// 상품 상세 - 세부 정보
	AdminProductVO getProductDetail(int product_num);

	// 상품 상세 - 색상, 사이즈, 재고
	List<AdminProductVO> getProductStock(int product_num);

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
