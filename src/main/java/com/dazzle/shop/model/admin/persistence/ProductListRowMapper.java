package com.dazzle.shop.model.admin.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dazzle.shop.model.admin.domain.AdminProductVO;

public class ProductListRowMapper implements RowMapper<AdminProductVO> {

	@Override
	public AdminProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		AdminProductVO vo = new AdminProductVO();

		vo.setList_num(rs.getInt("list_num"));
		vo.setProduct_num(rs.getInt("product_num"));
		vo.setProduct_name(rs.getString("product_name"));
		vo.setProduct_price(rs.getInt("product_price"));
		vo.setTotal_stock(rs.getInt("total_stock"));
		vo.setPage_num(rs.getInt("page_num"));

		return vo;
	}

}
