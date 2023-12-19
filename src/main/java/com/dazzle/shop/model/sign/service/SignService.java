package com.dazzle.shop.model.sign.service;

import com.dazzle.shop.model.sign.domain.SignVO;

public interface SignService {

	// find_id
	String findId(SignVO vo);

	// find_pwd
	int findPwd(SignVO vo);

	// sign_in
	int signIn(SignVO vo);

	////////////////////////////// DB에 없는 Service
	
	// check_email_pwd
	int checkEmailPwd();
	
	// send_email
	void sendEmail(String user_email, String authStr);
}
