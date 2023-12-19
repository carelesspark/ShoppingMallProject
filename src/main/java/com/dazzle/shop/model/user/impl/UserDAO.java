package com.dazzle.shop.model.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	@Autowired
	private JdbcTemplate template;



}
