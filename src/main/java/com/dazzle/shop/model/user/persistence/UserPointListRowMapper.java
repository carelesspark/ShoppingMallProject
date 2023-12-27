package com.dazzle.shop.model.user.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.user.domain.*;

public class UserPointListRowMapper implements RowMapper<UserPointVO> {

	@Override
	public UserPointVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserPointVO vo = new UserPointVO();
		vo.setOrder_date(rs.getDate("order_date"));
		vo.setOrder_num(rs.getInt("order_num"));
		vo.setPoint_type(rs.getInt("point_type"));
		vo.setPoints(rs.getInt("points"));
		vo.setSize_name(rs.getString("size_name"));
		vo.setColor_name(rs.getString("color_name"));
		vo.setProduct_name(rs.getString("product_name"));

		return vo;
	}

}
