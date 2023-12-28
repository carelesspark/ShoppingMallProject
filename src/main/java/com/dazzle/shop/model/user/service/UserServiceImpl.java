package com.dazzle.shop.model.user.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.user.domain.*;
import com.dazzle.shop.model.user.persistence.UserDAO;
import com.dazzle.shop.model.user.persistence.UserReplyListRowMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	// 유저 카드 내용 저장
	@Override
	public UserCardVO getUserCard(int user_num) {
		return userDAO.getUserCard(user_num);
	}

	@Override
	public UserCardVO getUserCard2(int user_num) {
		return userDAO.getUserCard2(user_num);
	}

	// 유저 번호와 일치하는 테이블 레코드 수
	@Override
	public int countRecords(String tableName, int user_num) {
		return userDAO.getRecords(tableName, user_num);
	}

	// 특정 날짜 사이의 유저 번호와 일치하는 테이블 레코드 수
	@Override
	public int countPointBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {
		return userDAO.countPointBetweenDates(user_num, startDate, endDate);
	}

	// 주문/배송 조회
	@Override
	public List<UserOrdersVO> getUserOrderList(UserOrdersVO vo) {
		return userDAO.getUserOrderList(vo);
	}

	// 나의 혜택
	// 포인트 내역
	public List<UserPointVO> getUserPointList(UserPointVO vo) {
		return userDAO.getUserPointList(vo);
	}

	// 상품 후기
	@Override
	public List<UserReviewVO> getUserReviewList(UserReviewVO vo) {
		return userDAO.getUserReviewList(vo);
	}

	// 유저 주문 조회(COUNT)
	@Override
	public UserOrdersVO orderCheck(int user_num) {

		return userDAO.orderCheck(user_num);
	}

	// 날짜 기준 상품 후기
	@Override
	public int countReviewBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {
		return userDAO.countReviewBetweenDates(user_num, startDate, endDate);
	}

	// 1대1 내역
	@Override
	public List<UserInquiryVO> getUserInquiryList(UserInquiryVO vo) {
		return userDAO.getUserInquiryList(vo);
	}

	// 날짜 기준 1대1 내역
	@Override
	public int countInquiryBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {
		return userDAO.countInquiryBetweenDates(user_num, startDate, endDate);
	}

	// 작성 글
	@Override
	public List<UserBoardVO> getUserBoardList(UserBoardVO vo) {
		return userDAO.getUserBoardList(vo);
	}

	// 날짜 기준 작성 글 수
	@Override
	public int countBoardBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {
		return userDAO.countBoardBetweenDates(user_num, startDate, endDate);
	}

	// 작성 댓글
	@Override
	public List<UserReplyVO> getUserReplyList(UserReplyVO vo) {
		return userDAO.getUserReplyList(vo);
	}

	// 날짜 기준 작성 댓글 수
	@Override
	public int countReplyBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate) {

		return userDAO.countReplyBetweenDates(user_num, startDate, endDate);
	}

	// 비밀번호 체크
	@Override
	public boolean checkPwd(int user_num, String pwd) {
		return userDAO.checkPwd(user_num, pwd);
	}

	// 회원정보 불러오기
	@Override
	public UserVO getUserInfo(int user_num) {
		return userDAO.getUserInfo(user_num);
	}

	@Override
	public String getPwd(int user_num) {
		return userDAO.getPwd(user_num);
	}

	////////////////////////////////////// 비동기
	@Override
	public boolean updatePwd(int user_num, String pwd) {
		return userDAO.updatePwd(user_num, pwd);
	}

	@Override
	public boolean updatePhone(int user_num, String user_phone) {
		return userDAO.updatePhone(user_num, user_phone);
	}
}
