package com.dazzle.shop.model.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
	List<BoardVO> getBoardList();	// 게시판 메인
	
	List<FileVO> getFileList();
	
	List<FileVO> getFileList(int ctgr_num);
	
	List<BoardVO> getCtgrBoardList(int ctgr_num);	// 게시판 카테고리별 보기
	
	List<BoardVO> getNoticeList(int pageNum);
	
	List<BoardVO> getQuestList(int pageNum);
	
	BoardVO getBoard(BoardVO vo);
	
	List<FileVO> getFile(BoardVO vo);
	
	BoardVO getNotice(BoardVO vo);
	
	Integer getNoticeTotalPage();
	
	BoardVO getQuest(BoardVO vo);
	
	Integer getQuestTotalPage();
	
	List<ReplyVO> getReply(BoardVO vo);
	
	ReplyVO getQuestReply(BoardVO vo);
	
	int writeBoard(BoardVO vo);
	
	List<PVO> getProductList();
	
	void insertBoardImg(int pno, String mainImageName);
	
	void insertPNum(BoardProductVO vo);
	
	void writeReply(ReplyVO vo);
	
	Integer ckQuestReply(ReplyVO vo);
	
	void writeNotice(BoardVO vo);
	
	void writeQuest(BoardVO vo);
	
	void deleteBoard(BoardVO vo);
	
	void deleteReply(ReplyVO vo);
	
	void deleteQuestReply(ReplyVO vo);
	
	void deleteNotice(BoardVO vo);
	
	void deleteQuest(BoardVO vo);
	
	void editBoard(BoardVO vo);
	
	void editNotice(BoardVO vo);
	
	void editQuest(BoardVO vo);
}
