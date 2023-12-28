package com.dazzle.shop.model.admin.service;

import java.util.List;

import com.dazzle.shop.model.admin.domain.*;

public interface AdminService {

	// 테이블 행 개수 출력
	int countTableRecord(String tableName);

	// 서브 카테고리용 레코드 개수 반환
	int countSubCategoryItems(int subCategoryNum);

	// 블랙리스트인 유저 수 반환
	int countBlacklist();

	// 서브카테고리 번호, 이름 출력
	List<SubCategoryVO> getSubCategoryList();

	// 회원 관리
	// 회원 목록
	List<AdminUserVO> getUserList(int currentPage, int usersPerPage);

	// 블랙리스트 목록
	List<AdminUserVO> getBlackist(int pageSize, int pageNum);

	// 상품 관리
	// 상품 목록
	List<AdminProductVO> getProductList(int subCategoryNum, int itemsPerPage, int currentPage);

	// 상품 상세 - 세부 정보
	AdminProductVO getProductDetail(int product_num);

	// 상품 상세 - 색상, 사이즈, 재고
	List<AdminProductVO> getProductStock(int product_num);

	// 상품 추가
	// 1단계: 추가하고 product_num 가져오기
	int getProductNum(int subCategoryNum);

	// 2단계: 제품 기본정보 추가
	void updateProductBasicInfo(AdminProductVO vo);

	// DB에 이미지 경로 추가
	void insertProductImg(int product_num, String img_name, int img_type);

	// 3단계: 제품 색상 추가
	int insertProductColor(int product_num, String color_name);

	// 제품 사이즈 및 재고 추가
	int insertProductSize(int color_num, String size_name, int product_stock);

	// 프로덕트 코드 저장
	void insertProductCode(int size_num);

	// 상품 수정

	// 상품 활성화
	void activateProduct(int product_num);

	// 상품 비활성화
	void deactivateProduct(int product_num);

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
