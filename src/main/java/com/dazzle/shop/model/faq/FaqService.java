package com.dazzle.shop.model.faq;

import java.util.List;


public interface FaqService {
	//faq 카테고리 목록
	public List<FaqCtgrVO> getCtgr();
	
	//faq 세부카테고리 목록
	public List<FaqSubCtgrVO> getSubCtgr();
	
	//faq 개수
	public Integer getFaqCount();
	
	//faq 질문 목록
	public List<FaqVO> getFaqList(Integer faq_count, Integer curr_page ) ;
	
	public Integer getFaqSubCtgrCount(Integer sub_ctgr_num);
	
	public List<FaqVO> getFaqSubCtgr(Integer start, Integer end ,Integer sub_ctgr_num);
	
	public FaqTotalCtgrVO getCurrCtgr(Integer sub_ctgr_num );
	
	public List<FaqTotalCtgrVO> getDetailCtgr() ;
	
	public FaqVO getFaq(FaqVO faq);
	
	//faq 추가하기
	public void insertFaq(FaqVO vo);
		
	//faq 수정하기
	public void updateFaq(FaqVO vo);
	
	//faq 삭제하기
	public void deleteFaq(FaqVO vo);
	
}
