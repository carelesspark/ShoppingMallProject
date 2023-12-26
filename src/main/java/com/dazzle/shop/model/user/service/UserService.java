package com.dazzle.shop.model.user.service;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.dazzle.shop.model.user.domain.*;
import com.dazzle.shop.model.user.persistence.UserReplyListRowMapper;

public interface UserService {

	// 유저 카드 내용 저장
	UserCardVO getUserCard(int user_num);

	// 유저 번호와 일치하는 테이블 레코드 수
	int countRecords(String tableName, int user_num);

	// 주문/배송 조회
	List<UserOrdersVO> getUserOrderList(UserOrdersVO vo);

	// 나의 혜택
	// 포인트 내역
	List<UserPointVO> getUserPointList(UserPointVO vo);

	// 특정 날짜 사이의 포인트 테이블 레코드 수
	int countPointBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate);

	// 상품 후기
	List<UserReviewVO> getUserReviewList(UserReviewVO vo);

	// 날짜 기준 상품 후기
	int countReviewBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate);

	// 1대1 내역
	List<UserInquiryVO> getUserInquiryList(UserInquiryVO vo);

	// 날짜 기준 1대1 내역
	int countInquiryBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate);

	// 작성 글
	List<UserBoardVO> getUserBoardList(UserBoardVO vo);

	// 날짜 기준 작성 글 수
	int countBoardBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate);

	// 작성 댓글
	List<UserReplyVO> getUserReplyList(UserReplyVO vo);

	// 날짜 기준 작성 댓글 수
	int countReplyBetweenDates(int user_num, java.sql.Date startDate, java.sql.Date endDate);

}
