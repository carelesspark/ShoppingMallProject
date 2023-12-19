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

	////////////////////////////// DB에 없는 Service

	// send_email
	void sendEmail(String user_email, String authStr);
}
