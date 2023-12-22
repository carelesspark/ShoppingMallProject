package com.dazzle.shop.model.admin.persistence;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.admin.domain.AdminUserVO;

@Repository("adminDAO")
public class AdminDAO {

	@Autowired
	private JdbcTemplate template;

	public final String USER_LIST = "WITH userlist AS ( SELECT ROW_NUMBER() OVER (ORDER BY ui.user_join_date DESC) AS list_num, "
			+ "u.user_name, u.login_type, ui.user_rank, ui.is_black_list, ui.user_join_date, ui.user_delete_date "
			+ "FROM users u JOIN user_info ui ON u.user_num = ui.user_num WHERE u.is_admin != 1) "
			+ "SELECT list_num, user_name, login_type, user_rank, is_black_list, user_join_date, user_delete_date, "
			+ "CEIL(list_num / ?) AS page_num FROM userlist WHERE CEIL(list_num / ?) = ? ORDER BY list_num";

	public List<AdminUserVO> getUserList(int pageSize, int pageNum) {
		try {
			return template.query(USER_LIST, new Object[] { pageSize, pageSize, pageNum }, new AdminUserRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

}
