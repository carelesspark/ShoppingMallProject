package com.dazzle.shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.dazzle.shop.user.service.UserService;

public class UserController {

	@Autowired
	private UserService userService;
	
	// 회원가입, 로그인 ...
}
