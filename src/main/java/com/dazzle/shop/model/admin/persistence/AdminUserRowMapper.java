package com.dazzle.shop.model.admin.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.admin.domain.AdminUserVO;

public class AdminUserRowMapper implements RowMapper<AdminUserVO> {

	@Override
	public AdminUserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminUserVO adminUserVO = new AdminUserVO();

		adminUserVO.setList_num(rs.getInt("list_num"));
		adminUserVO.setUser_name(rs.getString("user_name"));
		adminUserVO.setLogin_type(rs.getString("login_type"));
		adminUserVO.setUser_rank(rs.getString("user_rank"));
		adminUserVO.setIs_black_list(rs.getInt("is_black_list"));
		adminUserVO.setUser_join_date(rs.getDate("user_join_date"));
		adminUserVO.setUser_delete_date(rs.getDate("user_delete_date"));
		adminUserVO.setPage_num(rs.getInt("page_num"));

		return adminUserVO;
	}

}
