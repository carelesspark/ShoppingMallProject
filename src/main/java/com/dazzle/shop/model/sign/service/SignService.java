package com.dazzle.shop.model.sign.service;

import com.dazzle.shop.model.sign.domain.SignVO;

public interface SignService {

	/*
	 * 로그인
	 */
	SignVO login(SignVO vo);
	
	/*
	 * 관리자 로그인
	 */
	SignVO loginAdmin(SignVO vo);

	/*
	 * 아이디 찾기
	 */
	SignVO findId(SignVO vo);

	/*
	 * 비밀번호 재설정 - 첫번째 단계
	 */
	SignVO findPwd(SignVO vo);

	/*
	 * 비밀번호 재설정 - 두번째 단계
	 */
	void sendEmail(String user_email, String authStr);

	/*
	 * 비밀번호 재설정 - 세번째 단계
	 */
	void updatePwd(SignVO vo);

	/*
	 * 회원가입 - 아이디 중복 확인(비동기)
	 */
	boolean isIdDupl(String id);

	/*
	 * 회원가입 - 이메일 중복 확인(비동기)
	 */
	boolean isEmailDupl(String user_email);

	/*
	 * 회원가입
	 */
	void register(SignVO vo);
}
