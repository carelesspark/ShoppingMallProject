package com.dazzle.shop.model.admin.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.admin.domain.*;

@Repository("adminDAO")
public class AdminDAO {

	@Autowired
	private JdbcTemplate template;

	// 최근 가입한 유저 기준으로 (현재 페이지 - 1) * 페이지당 보여지는 유저 수, 페이지당 보여지는 유저 수
	public final String USER_LIST = "SELECT u.user_name, u.login_type, ui.user_rank, ui.is_black_list, ui.user_join_date, ui.user_delete_date "
			+ "FROM users u JOIN user_info ui ON u.user_num = ui.user_num WHERE u.is_admin = 0 ORDER BY ui.user_join_date DESC LIMIT ?, ?";

	public final String BLACKLIST = "SELECT u.user_name, u.login_type, ui.user_rank, ui.is_black_list, ui.user_join_date, ui.user_delete_date "
			+ "FROM users u JOIN user_info ui ON u.user_num = ui.user_num WHERE u.is_admin = 0 and ui.is_black_list = 1 "
			+ "ORDER BY ui.user_join_date DESC LIMIT ?, ?";

	public final String PRODUCT_LIST = "select p.product_num, p.product_name, p.product_price, SUM(ps.product_stock) total_stock "
			+ "FROM product p LEFT JOIN product_color pc ON p.product_num = pc.product_num "
			+ "LEFT JOIN product_size ps ON pc.color_num = ps.color_num WHERE p.sub_category_num = ? "
			+ "GROUP BY p.product_num, p.product_name, p.product_price ORDER BY p.product_date DESC LIMIT ?, ?";

	public final String PRODUCT_LIST2 = "WITH productlist AS (SELECT ROW_NUMBER() OVER (ORDER BY p.product_date DESC) AS list_num, "
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

	// 서브 카테고리용 레코드 개수 반환
	public int countSubCategoryItems(int subCategoryNum) {
		String sql = "select count(*) from product where sub_category_num = " + subCategoryNum;

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

	// 유저 블랙리스트 반환
	public List<AdminUserVO> getBlackist(int currentPage, int itemsPerPage) {
		int offset = (currentPage - 1) * itemsPerPage;
		int limit = itemsPerPage;

		try {
			return template.query(BLACKLIST, new Object[] { offset, limit }, new UserListRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyList();
		}
	}

	// 제품 리스트 반환
	public List<AdminProductVO> getProductList(int subCategoryNum, int itemsPerPage, int currentPage) {
		int offset = (currentPage - 1) * itemsPerPage;
		int limit = itemsPerPage;

		try {
			return template.query(PRODUCT_LIST, new Object[] { subCategoryNum, offset, limit },
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

	// 제품 추가 및 product_num 반환
	public int getProductNum(int subCategoryNum) {
		String sql = "INSERT INTO product (sub_category_num, product_name, product_info, product_date, product_price) "
				+ "VALUES (? , '', '', CURRENT_DATE, 0)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, subCategoryNum);

				return pstmt;
			}

		}, keyHolder);

		int productNum = keyHolder.getKey().intValue();

		return productNum;
	}

	// 제품 기본정보 추가
	public void updateProductBasicInfo(AdminProductVO vo) {
		String sql = "UPDATE product SET product_name = ?, product_info = ?, product_price = ? WHERE product_num = ?";

		try {
			template.update(sql, vo.getProduct_name(), vo.getProduct_info(), vo.getProduct_price(),
					vo.getProduct_num());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	// DB에 이미지 경로 추가
	public void insertProductImg(int product_num, String img_name, int img_type) {
		String sql = "INSERT INTO product_img (product_num, img_name, img_type) VALUES (?, ?, ?)";

		try {
			template.update(sql, product_num, img_name, img_type);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	// 제품 색상 추가
	public int insertProductColor(int product_num, String color_name) {
		String sql = "INSERT INTO product_color (product_num, color_name) VALUES (?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {
			template.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					pstmt.setInt(1, product_num);
					pstmt.setString(2, color_name);

					return pstmt;
				}

			}, keyHolder);

			int color_num = keyHolder.getKey().intValue();

			return color_num;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 제품 사이즈 및 재고 추가
	public int insertProductSize(int color_num, String size_name, int product_stock) {
		String sql = "INSERT INTO product_size (color_num, size_name, product_stock) VALUES (?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		try {
			template.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					pstmt.setInt(1, color_num);
					pstmt.setString(2, size_name);
					pstmt.setInt(3, product_stock);

					return pstmt;
				}

			}, keyHolder);

			return keyHolder.getKey().intValue();

		} catch (DataAccessException e) {
			e.printStackTrace();

			return -1;
		}
	}

	public void insertProductCode(int size_num) {
		System.out.println("insert into product_code");

		String sql = "INSERT INTO product_code (size_num) VALUES (" + size_num + ")";

		try {
			template.update(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	// 상품 활성화
	public void activateProduct(int product_num) {
		String sql = "Update product SET registration_status = 1 WHERE product_num = " + product_num;

		try {
			template.update(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	// 상품 비활성화
	public void deactivateProduct(int product_num) {
		String sql = "Update product SET registration_status = 0 WHERE product_num = " + product_num;

		try {
			template.update(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
