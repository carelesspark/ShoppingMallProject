package com.dazzle.shop.model.user.service;

import java.util.List;

import com.dazzle.shop.model.user.domain.*;

public interface UserService {

	/*
	 * 유저 카드 내용 저장
	 */
	UserVO getUserCard(int user_num);

	/*
	 * 주문/배송 조회
	 */
	List<UserOrdersVO> getUserOrderList(int user_num);

	/*
	 * 포인트
	 */

	/*
	 * 상품 후기
	 */
	List<UserReviewVO> getUserReviewList(int user_num);

}
