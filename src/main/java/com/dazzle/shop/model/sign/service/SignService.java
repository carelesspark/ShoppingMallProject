package com.dazzle.shop.model.sign.service;

import com.dazzle.shop.model.sign.domain.SignVO;

public interface SignService {

	// find_id
	SignVO findId(SignVO vo);

	// find_pwd
	SignVO findPwd(SignVO vo);

	// sign_in
	SignVO signIn(SignVO vo);

	// update_pwd
	void updatePwd(SignVO vo);

	///////////////////////// sign_up.jsp에서 사용되는 service

	boolean isIdDupl(String id);

	boolean isEmailDupl(String user_email);

	void signUp(SignVO vo);

	////////////////////////////// DB에 없는 Service

	// send_email
	void sendEmail(String user_email, String authStr);
}
