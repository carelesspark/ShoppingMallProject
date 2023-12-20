package com.dazzle.shop.model.faq.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.model.faq.FaqCtgrVO;
import com.dazzle.shop.model.faq.FaqSubCtgrVO;
import com.dazzle.shop.model.faq.FaqTotalCtgrVO;
import com.dazzle.shop.model.faq.FaqVO;

@Repository
public class FaqDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	private final String GET_FAQ_CTGR = "select * from faq_ctgr";
	private final String GET_FAQ_SUB_CTGR = "select * from faq_sub_ctgr";
	private final String GET_ALL_FAQ_COUNT = "select count(*) from faq";
	private final String GET_ALL_FAQ = "select * from faq ORDER BY faq_num LIMIT ? OFFSET ?";
	private final String GET_FAQ_COUNT = "select count(*) from faq where sub_ctgr_num = ?";
	private final String GET_FAQ = "select * from faq where sub_ctgr_num = ? ORDER BY faq_num LIMIT ? OFFSET ?";
	private final String GET_CURR_CTGR = "select * from faq_ctgr NATURAL JOIN faq_sub_ctgr WHERE sub_ctgr_num=?";
	
	
	
	public List<FaqCtgrVO> getCtgr() {
		System.out.println("===> getCtgr() 기능 처리");
		return jdbcTemplate.query(GET_FAQ_CTGR,new FaqCtgrRowMapper());
	}
		
	//faq 세부카테고리 목록
	public List<FaqSubCtgrVO> getSubCtgr() {
		System.out.println("===> getSubCtgr() 기능 처리");
		return jdbcTemplate.query(GET_FAQ_SUB_CTGR,new FaqSubCtgrRowMapper());
	}
	
	//faq 개수
	public Integer getFaqCount() {
        return jdbcTemplate.queryForObject(GET_ALL_FAQ_COUNT, Integer.class);
    }
	
	//faq 질문 목록
	public List<FaqVO> getFaq(Integer start, Integer end ) {
		Object[] args = {start, end};
		return jdbcTemplate.query(GET_ALL_FAQ, args, new FaqRowMapper());
	}
	
	//faq 세부카테고리별 개수
	public Integer getFaqSubCtgrCount(Integer sub_ctgr_num ) {
		Object[] args = {sub_ctgr_num};
	    return jdbcTemplate.queryForObject(GET_FAQ_COUNT, args, Integer.class);
	}
		
		//faq 질문 목록
	public List<FaqVO> getFaqSubCtgr(Integer start, Integer end, Integer sub_ctgr_num ) {
		Object[] args = {sub_ctgr_num, start, end};
		return jdbcTemplate.query(GET_FAQ, args, new FaqRowMapper());
	}
	
	public FaqTotalCtgrVO getCurrCtgr(Integer sub_ctgr_num ) {
		Object[] args = {sub_ctgr_num};
		return jdbcTemplate.queryForObject(GET_CURR_CTGR, args,new FaqTotalCtgrRowMapper());
	
	}
	
//	//faq 추가하기
//	public void insertFaq(FaqVO vo) {
//		System.out.println("===> deleteAddress() 기능 처리");
//		jdbcTemplate.update(, vo.getAddr_num());
//		return;
//	}
//			
//	//faq 수정하기
//	public void updateFaq(FaqVO vo) {
//		System.out.println("===> deleteAddress() 기능 처리");
//		jdbcTemplate.update(ADDRESS_DELETE, vo.getAddr_num());
//		return;
//	}
//		
//	//faq 삭제하기
//	public void deleteFaq(FaqVO vo) {
//		System.out.println("===> deleteAddress() 기능 처리");
//		jdbcTemplate.update(ADDRESS_DELETE, vo.getAddr_num());
//		return;
//	}
}
