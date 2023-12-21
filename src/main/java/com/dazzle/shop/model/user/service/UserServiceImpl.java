package com.dazzle.shop.model.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.user.persistence.UserDAO;

@Service
public class UserServiceImpl {
	@Autowired
	private UserDAO userDAO;
}
