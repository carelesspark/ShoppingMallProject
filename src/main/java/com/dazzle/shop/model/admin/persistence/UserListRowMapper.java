package com.dazzle.shop.model.admin.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.admin.domain.AdminUserVO;

public class UserListRowMapper  implements RowMapper<AdminUserVO> {

	@Override
	public AdminUserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminUserVO vo = new AdminUserVO();
		vo.setUser_name(rs.getString("user_name"));
		vo.setLogin_type(rs.getString("login_type"));
		vo.setUser_rank(rs.getString("user_rank"));
		vo.setIs_black_list(rs.getInt("is_black_list"));
		vo.setUser_join_date(rs.getDate("user_join_date"));
		vo.setUser_delete_date(rs.getDate("user_delete_date"));
		
		return vo;
	}

}
