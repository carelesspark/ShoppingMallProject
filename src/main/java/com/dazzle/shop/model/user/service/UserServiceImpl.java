package com.dazzle.shop.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.user.domain.UserOrdersVO;
import com.dazzle.shop.model.user.domain.UserReviewVO;
import com.dazzle.shop.model.user.domain.UserVO;
import com.dazzle.shop.model.user.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	
	/*
	 * 유저 카드 내용 저장
	 */
	@Override
	public UserVO getUserCard(int user_num) {
		return userDAO.getUserCard(user_num);
	}

	/*
	 * 주문/배송 조회
	 */
	@Override
	public List<UserOrdersVO> getUserOrderList(int user_num, UserOrdersVO vo) {
		return userDAO.getUserOrderList(user_num, vo);
	}

	@Override
	public List<UserOrdersVO> getOrderList2(int user_num, int date) {
		
		return userDAO.getOrderList2(user_num, date);
	}

	
	/*
	 * 포인트
	 */

	@Override
	public UserOrdersVO orderCheck(int user_num) {
		
		return userDAO.orderCheck(user_num);
	}

	/*
	 * 상품 후기
	 */
	@Override
	public List<UserReviewVO> getUserReviewList(int user_num) {
		return userDAO.getUserReviewList(user_num);
	}

}
