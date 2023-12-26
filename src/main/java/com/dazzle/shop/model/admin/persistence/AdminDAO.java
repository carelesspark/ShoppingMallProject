package com.dazzle.shop.model.admin.persistence;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.admin.domain.*;

@Repository("adminDAO")
public class AdminDAO {

	@Autowired
	private JdbcTemplate template;

	public final String USER_LIST2 = "WITH blacklist AS ( SELECT ROW_NUMBER() OVER (ORDER BY ui.user_join_date DESC) AS list_num, "
			+ "u.user_name, u.login_type, ui.user_rank, ui.is_black_list, ui.user_join_date, ui.user_delete_date "
			+ "FROM users u JOIN user_info ui ON u.user_num = ui.user_num WHERE u.is_admin != 1) "
			+ "SELECT list_num, user_name, login_type, user_rank, is_black_list, user_join_date, user_delete_date, "
			+ "CEIL(list_num / ?) AS page_num FROM blacklist WHERE CEIL(list_num / ?) = ? ORDER BY list_num";

	// 최근 가입한 유저 기준으로 (현재 페이지 - 1) * 페이지당 보여지는 유저 수, 페이지당 보여지는 유저 수
	public final String USER_LIST = "SELECT u.user_name, u.login_type, ui.user_rank, ui.is_black_list, ui.user_join_date, ui.user_delete_date "
			+ "FROM users u JOIN user_info ui ON u.user_num = ui.user_num WHERE u.is_admin = 0 ORDER BY ui.user_join_date DESC LIMIT ?, ?";

	public final String BLACKLIST = "WITH userlist AS ( SELECT ROW_NUMBER() OVER (ORDER BY ui.user_join_date DESC) AS list_num, "
			+ "u.user_name, u.login_type, ui.user_rank, ui.user_join_date, ui.user_delete_date "
			+ "FROM users u JOIN user_info ui ON u.user_num = ui.user_num WHERE ui.is_black_list = 1) "
			+ "SELECT list_num, user_name, login_type, user_rank, user_join_date, user_delete_date, "
			+ "CEIL(list_num / ?) AS page_num FROM userlist WHERE CEIL(list_num / ?) = ? ORDER BY list_num";

	public final String PRODUCT_LIST = "WITH productlist AS (SELECT ROW_NUMBER() OVER (ORDER BY p.product_date DESC) AS list_num, "
			+ "p.product_num, p.product_name, p.product_price, SUM(ps.product_stock) AS total_stock "
			+ "FROM product p JOIN product_color pc ON p.product_num = pc.product_num JOIN product_size ps ON pc.color_num = ps.color_num "
			+ "WHERE p.sub_category_num = ? GROUP BY p.product_num, p.product_name, p.product_price) "
			+ "SELECT list_num, product_num, product_name, product_price, total_stock, "
			+ "CEIL(list_num / ?) AS page_num FROM productlist WHERE CEIL(list_num / ?) = ? ORDER BY list_num";

	public final String PRODUCT_DETAIL = "SELECT p.product_num, p.product_name, p.product_info, "
			+ "p.product_date, p.product_sell, p.product_price, p.modify_date, p.delete_date, "
			+ "p.registration_status, s.sub_category_num, s.sub_category_name, c.category_num, c.category_name "
			+ "FROM product p JOIN sub_category s ON p.sub_category_num = s.sub_category_num "
			+ "JOIN category c ON s.category_num = c.category_num WHERE p.product_num = ?";

	public final String PRODUCT_STOCK = "SELECT pc.color_name, ps.size_name, ps.product_stock FROM product_color pc "
			+ "JOIN product_size ps ON pc.color_num = ps.color_num WHERE pc.product_num = ?";

	// 테이블 레코드 총 개수 반환
	public int getTotalCount(String tableName) {
		String sql = "select count(*) from " + tableName;

		return template.queryForObject(sql, Integer.class);
	}

	// 블랙리스트인 유저 수 반환
	public int countBlacklist() {
		String sql = "select count(*) from user_info where is_black_list = 1";

		return template.queryForObject(sql, Integer.class);
	}

	// 서브 카테고리 이름과 번호 반환
	public List<SubCategoryVO> getSubCategoryList() {
		String sql = "select sub_category_num, sub_category_name from sub_category";

		RowMapper<SubCategoryVO> rowMapper = (rs, rowNum) -> {
			SubCategoryVO vo = new SubCategoryVO();
			vo.setSub_category_num(rs.getInt("sub_category_num"));
			vo.setSub_category_name(rs.getString("sub_category_name"));
			return vo;
		};

		return template.query(sql, rowMapper);
	}

	// 최근 가입한 유저 기준으로 (현재 페이지 - 1) * 페이지당 보여지는 유저 수, 페이지당 보여지는 유저 수
	public List<AdminUserVO> getUserList(int currentPage, int usersPerPage) {
		int offset = (currentPage - 1) * usersPerPage;
		int limit = usersPerPage;

		try {
			return template.query(USER_LIST, new Object[] { offset, limit }, new UserListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 유저 리스트 반환
	public List<AdminUserVO> getUserList2(int pageSize, int pageNum) {

		try {
			return template.query(USER_LIST, new Object[] { pageSize, pageSize, pageNum }, new AdminUserRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 유저 블랙리스트 반환
	public List<AdminUserVO> getBlackist(int pageSize, int pageNum) {

		try {
			return template.query(BLACKLIST, new Object[] { pageSize, pageSize, pageNum },
					new AdminBlacklistRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 제품 리스트 반환
	public List<AdminProductVO> getProductList(int subCategoryNum, int pageSize, int pageNum) {

		try {
			return template.query(PRODUCT_LIST, new Object[] { subCategoryNum, pageSize, pageSize, pageNum },
					new ProductListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 제품 상세정보 반환 - 제품, 세부 카테고리, 카테고리 관련
	public AdminProductVO getProductDetail(int product_num) {

		try {
			return template.queryForObject(PRODUCT_DETAIL, new ProductDetailRowMapper(), product_num);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// 제품 상세정보 반환 - 이미지
	// 제품 상세정보 반환 - 색상, 사이즈 밑 재고
	public List<AdminProductVO> getProductStock(int product_num) {

		RowMapper<AdminProductVO> rowMapper = (rs, rowNum) -> {
			AdminProductVO vo = new AdminProductVO();
			vo.setColor_name(rs.getString("color_name"));
			vo.setSize_name(rs.getString("size_name"));
			vo.setProduct_stock(rs.getInt("product_stock"));

			return vo;
		};

		try {
			return template.query(PRODUCT_STOCK, new Object[] { product_num }, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

}
