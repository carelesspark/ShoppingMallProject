package com.dazzle.shop.model.board;

import java.util.List;

public interface BoardService {
	List<BoardVO> getBoardList();
	
	List<BoardVO> getNoticeList();
	
	List<BoardVO> getQuestList();
	
	BoardVO getBoard(BoardVO vo);
	
	BoardVO getNotice(BoardVO vo);
	
	BoardVO getQuest(BoardVO vo);
	
	List<ReplyVO> getReply(BoardVO vo);
	
	ReplyVO getQuestReply(BoardVO vo);
	
	void writeBoard(BoardVO vo);
	
	void writeReply(ReplyVO vo);
	
	void writeNotice(BoardVO vo);
	
	void writeQuest(BoardVO vo);
	
	void deleteBoard(BoardVO vo);
	
	void deleteReply(ReplyVO vo);
	
	void deleteNotice(BoardVO vo);
	
	void deleteQuest(BoardVO vo);
}
