package com.dazzle.shop.model.user;

public interface UserService {

	// find id
	String findId(UserVO vo);

	// sign in
	int signInId(UserVO vo);
}
