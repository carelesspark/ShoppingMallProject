package com.dazzle.shop.model.admin.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.admin.domain.AdminProductVO;

public class ProductDetailRowMapper implements RowMapper<AdminProductVO> {

	@Override
	public AdminProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		AdminProductVO vo = new AdminProductVO();

		vo.setProduct_num(rs.getInt("product_num"));
		vo.setProduct_name(rs.getString("product_name"));
		vo.setProduct_info(rs.getString("product_info"));
		vo.setProduct_date(rs.getDate("product_date"));
		vo.setProduct_sell(rs.getInt("product_sell"));
		vo.setProduct_price(rs.getInt("product_price"));
		vo.setModify_date(rs.getDate("modify_date"));
		vo.setDelete_date(rs.getDate("delete_date"));
		vo.setRegistration_status(rs.getInt("registration_status"));
		vo.setSub_category_num(rs.getInt("sub_category_num"));
		vo.setSub_category_name(rs.getString("sub_category_name"));
		vo.setCategory_num(rs.getInt("category_num"));
		vo.setCategory_name(rs.getString("category_name"));

		return vo;
	}

}
