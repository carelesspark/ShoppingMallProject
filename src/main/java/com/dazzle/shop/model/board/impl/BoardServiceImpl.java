package com.dazzle.shop.model.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dazzle.shop.model.board.BoardService;
import com.dazzle.shop.model.board.BoardVO;
import com.dazzle.shop.model.board.ReplyVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}

	@Override
	public List<BoardVO> getNoticeList() {
		// TODO Auto-generated method stub
		return boardDAO.getNoticeList();
	}
	
	@Override
	public List<BoardVO> getQuestList() {
		// TODO Auto-generated method stub
		return boardDAO.getQuestList();
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(vo);
	}
	
	@Override
	public BoardVO getNotice(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getNotice(vo);
	}
	
	@Override
	public BoardVO getQuest(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getQuest(vo);
	}

	@Override
	public List<ReplyVO> getReply(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getReply(vo);
	}
	
	@Override
	public ReplyVO getQuestReply(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getQuestReply(vo);
	}
	
	@Override
	public void writeBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.writeBoard(vo);
	}
	
	@Override
	public void writeReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		boardDAO.writeReply(vo);
	}

	@Override
	public void writeNotice(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.writeNotice(vo);
	}

	@Override
	public void writeQuest(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.writeQuest(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(vo);
	}
	
	@Override
	public void deleteReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteReply(vo);
	}

	@Override
	public void deleteNotice(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteNotice(vo);
	}

	@Override
	public void deleteQuest(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteQuest(vo);
	}
	
	@Override
	public void editBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.editBoard(vo);
	}

	@Override
	public void editNotice(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.editNotice(vo);
	}

	@Override
	public void editQuest(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.editQuest(vo);
	}
	
}
