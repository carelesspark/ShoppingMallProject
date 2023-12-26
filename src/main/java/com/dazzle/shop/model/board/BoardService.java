package com.dazzle.shop.model.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
	List<BoardVO> getBoardList();
	
	List<BoardVO> getBoardCateList(String ctgr_name);
	
	List<FileVO> getFile();
	
	List<FileVO> getFileList(BoardVO vo);
	
	List<BoardVO> getNoticeList(int pageNum);
	
	List<BoardVO> getQuestList(int pageNum);
	
	BoardVO getBoard(BoardVO vo);
	
	CateVO getCate(BoardVO vo);
	
	BoardProCodeVO getCode(BoardVO vo);
	
	BoardVO getNotice(BoardVO vo);
	
	Integer getNoticeTotalPage();
	
	BoardVO getQuest(BoardVO vo);
	
	Integer getQuestTotalPage();
	
	List<ReplyVO> getReply(BoardVO vo);
	
	ReplyVO getQuestReply(BoardVO vo);
	
	void writeBoard(BoardVO vo);
	
	void fileUpload(MultipartFile file);
	
	void insertCate(CateVO vo);
	
	void insertNullCate(CateVO vo);
	
	void insertProduct_code(BoardProCodeVO vo);
	
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
	
	void editBoardNoTag(BoardVO vo);
	
	void editNotice(BoardVO vo);
	
	void editQuest(BoardVO vo);
}
