package com.dazzle.shop.model.faq.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.faq.*;

@Service("faqService")
public class FaqServiceImpl implements FaqService {

	 
    @Autowired
    public FaqDAO faqDAO;
	
    
	//faq 카테고리 목록
    @Override
	public List<FaqCtgrVO> getCtgr() {
		return faqDAO.getCtgr();
	}
		
	//faq 세부카테고리 목록
    @Override
	public List<FaqSubCtgrVO> getSubCtgr() {
		return faqDAO.getSubCtgr();
	}
    
  //faq 개수
    @Override
  	public Integer getFaqCount() {
		return faqDAO.getFaqCount();
    	
    }
    
  	@Override
  	//faq 질문 목록
  	public List<FaqVO> getFaqList(Integer faq_count, Integer curr_page ) {
  		return faqDAO.getFaqList(faq_count, curr_page);
	}
		
  	@Override
  	public Integer getFaqSubCtgrCount(Integer sub_ctgr_num) {
  	       return faqDAO.getFaqSubCtgrCount(sub_ctgr_num);
  	}
  		
  	@Override
  	public List<FaqVO> getFaqSubCtgr(Integer start, Integer end,Integer sub_ctgr_num) {
  		return faqDAO.getFaqSubCtgr(start, end,sub_ctgr_num);
  	}
  	@Override
  	public FaqTotalCtgrVO getCurrCtgr(Integer sub_ctgr_num ) {
  		return faqDAO.getCurrCtgr(sub_ctgr_num);
  	}
  	@Override
  	public List<FaqTotalCtgrVO> getDetailCtgr(){
  		return faqDAO.getDetailCtgr();
  	}
	//faq 추가하기
    @Override
	public void insertFaq(FaqVO vo) {
    	faqDAO.insertFaq(vo);
	}
    @Override
    public FaqVO getFaq(FaqVO faq) {
    	return faqDAO.getFaq(faq);
    }
			
	//faq 수정하기
    @Override
	public void updateFaq(FaqVO vo) {
    	faqDAO.updateFaq(vo);
	}
		
	//faq 삭제하기
    @Override
	public void deleteFaq(FaqVO vo) {
    	faqDAO.deleteFaq(vo);
	}
}
