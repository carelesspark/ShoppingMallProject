package com.dazzle.shop.model.faq.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dazzle.shop.model.faq.FaqVO;

@Repository
public class FaqDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	private final String GET_FAQ_CTGR = "select * from faq_ctgr";
	private final String GET_FAQ_SUB_CTGR = "select * from faq_sub_ctgr";
	private final String GET_ALL_FAQ_COUNT = "select count(*) from faq";
	private final String GET_ALL_FAQ = "select * from faq ORDER BY faq_num desc LIMIT ? OFFSET ?";
	private final String GET_FAQ_COUNT = "select count(*) from faq where sub_ctgr_num = ?";
	private final String GET_FAQ_LIST = "select * from faq where sub_ctgr_num = ? ORDER BY faq_num desc LIMIT ? OFFSET ?";
	private final String GET_CURR_CTGR = "select * from faq_ctgr NATURAL JOIN faq_sub_ctgr WHERE sub_ctgr_num=?";
	private final String GET_ALL_DETAIL_CTGR = "select * from faq_ctgr NATURAL JOIN faq_sub_ctgr";
	private final String INSERT_FAQ = "insert into faq (question, answer, sub_ctgr_num) values(?, ?, ?)";
	private final String DELETE_FAQ = "delete from faq where faq_num = ?";
	private final String GET_FAQ = "select * from faq where faq_num = ?";
	private final String UPDATE_FAQ = "update faq set question = ?, answer = ?, sub_ctgr_num = ? where faq_num = ?";
	 
	public List<FaqVO> getCtgr() {
		return jdbcTemplate.query(GET_FAQ_CTGR,new FaqCtgrRowMapper());
	}
		
	//faq 세부카테고리 목록
	public List<FaqVO> getSubCtgr() {
		return jdbcTemplate.query(GET_FAQ_SUB_CTGR,new FaqSubCtgrRowMapper());
	}
	
	//faq 개수
	public Integer getFaqCount() {
        return jdbcTemplate.queryForObject(GET_ALL_FAQ_COUNT, Integer.class);
    }
	
	//faq 질문 목록
	public List<FaqVO> getFaqList(Integer start, Integer end ) {
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
		return jdbcTemplate.query(GET_FAQ_LIST, args, new FaqRowMapper());
	}
	
	public List<FaqVO> getDetailCtgr() {
		return jdbcTemplate.query(GET_ALL_DETAIL_CTGR,new FaqTotalCtgrRowMapper());
	}
	
	public FaqVO getCurrCtgr(Integer sub_ctgr_num ) {
		Object[] args = {sub_ctgr_num};
		return jdbcTemplate.queryForObject(GET_CURR_CTGR, args,new FaqTotalCtgrRowMapper());
	
	}
	
	
	//faq 추가하기
	public void insertFaq(FaqVO vo) {
		jdbcTemplate.update(INSERT_FAQ, vo.getQuestion(), vo.getAnswer(), vo.getSub_ctgr_num());
		return;
	}
	
	public FaqVO getFaq(FaqVO faq) {
		Object[] args = {faq.getFaq_num()};
		return jdbcTemplate.queryForObject(GET_FAQ,args,new FaqRowMapper());
	}
	
			
	//faq 수정하기
	public void updateFaq(FaqVO vo) {
		jdbcTemplate.update(UPDATE_FAQ, vo.getQuestion(), vo.getAnswer(), vo.getSub_ctgr_num(), vo.getFaq_num());
		return;
	}
		
	//faq 삭제하기
	public void deleteFaq(FaqVO vo) {
		jdbcTemplate.update(DELETE_FAQ, vo.getFaq_num());
		return;
	}
}
