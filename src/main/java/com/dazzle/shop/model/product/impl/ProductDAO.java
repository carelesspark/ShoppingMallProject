package com.dazzle.shop.model.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.product.CategoryVO;
import com.dazzle.shop.model.product.InquiryVO;
import com.dazzle.shop.model.product.ProductCodeVO;
import com.dazzle.shop.model.product.ProductColorVO;
import com.dazzle.shop.model.product.ProductImgVO;
import com.dazzle.shop.model.product.ProductSizeVO;
import com.dazzle.shop.model.product.ProductVO;
import com.dazzle.shop.model.product.ProductsVO;
import com.dazzle.shop.model.product.ReviewVO;
import com.dazzle.shop.model.product.SubCategoryVO;

@Repository("product_dao")
public class ProductDAO {

	@Autowired
	private JdbcTemplate jdbc_template;
	@Autowired
	private ProductRowMapper productRowMapper;
	@Autowired
	private ProductColorRowMapper productColorRowMapper;
	@Autowired
	private ProductSizeRowMapper productSizeRowMapper;

	
	private final String get_category = "SELECT * FROM category c " + "WHERE c.category_num = ?";

	private final String get_sub_category = "SELECT * FROM sub_category s " + "WHERE s.category_num = ?";

	private final String product_info = "SELECT * FROM product " + "WHERE product_num = ?";

	private final String product_colors = "SELECT * FROM product_color " + "WHERE product_num = ?";

	private final String product_sizes = "SELECT * FROM product_size " + "WHERE color_num = ? "
			+ "ORDER BY size_num desc";

	private final String product_img = "SELECT * FROM product_img WHERE img_type = 0 and product_num = ?";
	
	private final String get_category_by_products_paged = "SELECT p.product_num, p.product_name, p.product_price, pi.img_name "
		    + "FROM product p "
		    + "JOIN sub_category s on p.sub_category_num = s.sub_category_num "
		    + "JOIN category c ON s.category_num = c.category_num "
		    + "JOIN product_img pi ON p.product_num = pi.product_num "
		    + "WHERE pi.img_type = 2 and c.category_num = ? LIMIT ? OFFSET ?";
	
	private final String count_category_products = "SELECT COUNT(*) " 
			+ "FROM product p "
			+ "JOIN sub_category s on p.sub_category_num = s.sub_category_num "
			+ "JOIN category c ON s.category_num = c.category_num " 
			+ "JOIN product_img pi ON p.product_num = pi.product_num "
			+ "WHERE c.category_num = ?";
	
	private final String get_sub_category_by_products_paged = "SELECT p.product_num, p.product_name, p.product_price, pi.img_name "
	        + "FROM product p "
	        + "JOIN product_img pi ON p.product_num = pi.product_num "
	        + "WHERE pi.img_type = 2 and p.sub_category_num = ? LIMIT ? OFFSET ?";
	
	private final String count_sub_category_products = "SELECT COUNT(*) " 
			+ "FROM product p "
			+ "JOIN sub_category s on p.sub_category_num = s.sub_category_num " 
			+ "JOIN product_img pi ON p.product_num = pi.product_num "
			+ "WHERE s.sub_category_num = ?";

	private final String search_result_paged = "SELECT p.product_num, p.product_name, p.product_price, pi.img_name "
	        + "FROM product p "
	        + "JOIN product_img pi ON p.product_num = pi.product_num "
	        + "WHERE pi.img_type = 2 and p.product_name LIKE ? LIMIT ? OFFSET ?";
	
	private final String count_search_keyword_products = "SELECT COUNT(*) " 
			+ "FROM product p " 
			+ "JOIN product_img pi ON p.product_num = pi.product_num "
			+ "WHERE p.product_name LIKE ?";
	
	private final String  GET_REVIEW = "SELECT" + 
			"    pc.product_code," + 
			"    ps.size_name," + 
			"    pr.color_name," + 
			"    a.id," + 
			"    ri.review_img," + 
			"    r.review_date," + 
			"    r.review_content," + 
			"    r.review_ratings," + 
			"    r.review_num" + 
			" FROM" + 
			"    review r" + 
			" JOIN" + 
			"    product_code pc ON r.product_code = pc.product_code" + 
			" JOIN" + 
			"    product_size ps ON pc.size_num = ps.size_num" + 
			" JOIN" + 
			"    product_color pr ON ps.color_num = pr.color_num" + 
			" JOIN" + 
			"	product p ON p.product_num = pr.product_num" + 
			" JOIN" + 
			"    users u ON r.user_num = u.user_num" + 
			" JOIN" + 
			"    auth_id a ON u.user_num = a.user_num" + 
			" LEFT JOIN" + 
			"    review_img ri ON r.review_num = ri.review_num" + 
			" WHERE" + 
			"    p.product_num = ?" + 
			" ORDER BY r.review_date desc" +
			" LIMIT ? OFFSET ?";
	
	private final String  GET_REVIEW_SOME = "SELECT" + 
			"    pc.product_code," + 
			"    ps.size_name," + 
			"    pr.color_name," + 
			"    a.id," + 
			"    ri.review_img," + 
			"    r.review_date," + 
			"    r.review_content," + 
			"    r.review_ratings," + 
			"    r.review_num" + 
			" FROM" + 
			"    review r" + 
			" JOIN" + 
			"    product_code pc ON r.product_code = pc.product_code" + 
			" JOIN" + 
			"    product_size ps ON pc.size_num = ps.size_num" + 
			" JOIN" + 
			"    product_color pr ON ps.color_num = pr.color_num" + 
			" JOIN" + 
			"	product p ON p.product_num = pr.product_num" + 
			" JOIN" + 
			"    users u ON r.user_num = u.user_num" + 
			" JOIN" + 
			"    auth_id a ON u.user_num = a.user_num" + 
			" LEFT JOIN" + 
			"    review_img ri ON r.review_num = ri.review_num" + 
			" WHERE" + 
			"    p.product_num = ?" + 
			" ORDER BY r.review_date desc" +
			" LIMIT 3";
	
	private final String  GET_REVIEW_COUNT = "SELECT COUNT(*) as count" + 
			" FROM" + 
			"    review r" + 
			" JOIN" + 
			"    product_code pc ON r.product_code = pc.product_code" + 
			" JOIN" + 
			"    product_size ps ON pc.size_num = ps.size_num" + 
			" JOIN" + 
			"    product_color pr ON ps.color_num = pr.color_num" + 
			" JOIN" + 
			"	product p ON p.product_num = pr.product_num" + 
			" JOIN" + 
			"    users u ON r.user_num = u.user_num" + 
			" JOIN" + 
			"    auth_id a ON u.user_num = a.user_num" + 
			" LEFT JOIN" + 
			"    review_img ri ON r.review_num = ri.review_num" + 
			" WHERE" + 
			"    p.product_num = ?" ;

	
	
	private final String get_product_code = "SELECT * FROM product_code p "
			+ "WHERE p.size_num = ?";
	
	private final String add_cart = "INSERT INTO cart "
			+ "(user_num, product_code, amount) "
			+ "VALUES (?, ?, ?)";

	private final String INSERT_INQUIRY = "INSERT INTO inquiry VALUES(DEFAULT, ?, ?, NOW(), ?, ?);";
	
	private final String GET_INQUIRY = "select * from inquiry WHERE product_num = ? LIMIT ? OFFSET ?";
	
	private final String GET_INQUIRY_COUNT = "select count(*) AS total_inquiry from inquiry WHERE product_num = ?";
	
	private final String INSERT_REVIEW = "INSERT INTO review(user_num, product_code, review_content, review_ratings, review_date)"
			+ " VALUES(?, ?, ?, ?, NOW());";
	
	private final String GET_REVIEW_ONE = "SELECT review_num FROM review WHERE user_num = ? and product_code = ? and review_ratings = ? order by review_num desc LIMIT 1";
	
	private final String INSERT_REVIEW_IMG = "INSERT INTO review_img(review_num, review_img)"
			+ " VALUES(?, ?);";

	public List<ProductsVO> get_category_by_products_paged(String _category_num, int limit, int offset) {
	    return jdbc_template.query(get_category_by_products_paged, new Object[] { _category_num, limit, offset }, new ProductsRowMapper());
	}
	
	public List<ProductsVO> get_sub_category_by_products_paged(String _sub_category_num, int limit, int offset) {
	    return jdbc_template.query(get_sub_category_by_products_paged, new Object[] { _sub_category_num, limit, offset }, new ProductsRowMapper());
	}

	public List<ProductsVO> search_result_paged(String _search_keyword, int limit, int offset) {
	    return jdbc_template.query(search_result_paged, new Object[] { _search_keyword, limit, offset }, new ProductsRowMapper());
	}
	
	public int count_category_products(String _category_num) {
	    return jdbc_template.queryForObject(count_category_products, new Object[] { _category_num }, Integer.class);
	}
	
	public int count_sub_category_products(String _sub_category_num) {
	    return jdbc_template.queryForObject(count_sub_category_products, new Object[] { _sub_category_num }, Integer.class);
	}
	
	public int count_search_products(String _search_keyword) {
	    return jdbc_template.queryForObject(count_search_keyword_products, new Object[] { _search_keyword }, Integer.class);
	}

	public List<CategoryVO> get_category(String _category_num) {
		System.out.println("카테고리");
		return jdbc_template.query(get_category, new Object[] { _category_num }, new CategoryRowMapper());
	}

	public List<SubCategoryVO> get_sub_category(String _category_num) {
		System.out.println("서브 카테고리");
		return jdbc_template.query(get_sub_category, new Object[] { _category_num }, new SubCategoryRowMapper());
	}

	public ProductVO product_info(int _product_num) {
		System.out.println("상품 정보");
		return jdbc_template.queryForObject(product_info, new Object[] { _product_num }, productRowMapper);
	}

	public List<ProductColorVO> product_colors(int _product_num) {
		System.out.println("색상");
		return jdbc_template.query(product_colors, new Object[] { _product_num }, productColorRowMapper);
	}

	public List<ProductSizeVO> product_sizes(int _color_num) {
		System.out.println("사이즈");
		return jdbc_template.query(product_sizes, new Object[] { _color_num }, productSizeRowMapper);
	}

	public ProductImgVO product_img(int _product_num) {
		System.out.println("이미지");
		try {
		return jdbc_template.queryForObject(product_img, new Object[] { _product_num }, new ProductImgRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public ProductCodeVO get_product_code(int _size_num) {
		System.out.println("상품코드");
		return jdbc_template.queryForObject(get_product_code, new Object[] {_size_num}, new ProductCodeRowMapper());
	}
	
	public void insert_cart(int _user_num, int _product_code, int _amount) {
		System.err.println("장바구니 추가");
		jdbc_template.update(add_cart, _user_num, _product_code, _amount);
	}


	public List<ReviewVO> getReview(Integer product_num, Integer start, Integer end) {
		System.out.println("리뷰 목록");
		return jdbc_template.query(GET_REVIEW, new Object[] {product_num, start, end}, new ReviewRowMapper());
		
	}
	
	public List<ReviewVO> getReviewSome(ReviewVO vo) {
		System.out.println("리뷰 목록");
		return jdbc_template.query(GET_REVIEW_SOME, new Object[] {vo.getProduct_num()}, new ReviewRowMapper());
		
	}
	
	public ReviewVO getReviewCount(ReviewVO vo) {
		System.out.println("리뷰 개수");
		return jdbc_template.queryForObject(GET_REVIEW_COUNT, new Object[] {vo.getProduct_num()}, new ReviewCountRowMapper());
	}

	public void insertInquiry(InquiryVO vo) {
		System.out.println("insertInquiry()");
		jdbc_template.update(INSERT_INQUIRY, vo.getUser_num(), vo.getProduct_num(), vo.getInquiry_title(), vo.getInquiry_content());
		return;
	}
	
	public void insertReview(ReviewVO vo) {
		System.out.println("insertReview()");
		jdbc_template.update(INSERT_REVIEW, vo.getUser_num(), vo.getProduct_code(), vo.getReview_content(), vo.getReview_ratings());
		return;
	} 
	public List<InquiryVO> getInquiry(int _product_num, int a, int b) {
		System.out.println("getInquiry()");
		return jdbc_template.query(GET_INQUIRY, new Object[] {_product_num, a, b}, new InquiryRowMapper());

	}
	
	public InquiryVO getInquiryCount(int _product_num) {
		System.out.println("getInquiryCount()");
		return jdbc_template.queryForObject(GET_INQUIRY_COUNT, new Object[] {_product_num}, new InquiryCountRowMapper());
	}

	public ReviewVO getReviewOne(ReviewVO vo) {
		System.out.println("getReviewOne()");
		return jdbc_template.queryForObject(GET_REVIEW_ONE, new Object[] {vo.getUser_num(), vo.getProduct_code(),
				vo.getReview_ratings()}, new ReviewNumRowMapper());
	}
	public void insertReviewImg(ReviewVO vo) {
		System.out.println("insertReviewImg()");
		jdbc_template.update(INSERT_REVIEW_IMG, vo.getReview_num(), vo.getReview_img());
		return;
	} 
}
