package com.dazzle.shop.model.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dazzle.shop.model.board.BoardProCodeVO;
import com.dazzle.shop.model.board.BoardService;
import com.dazzle.shop.model.board.BoardVO;
import com.dazzle.shop.model.board.CateVO;
import com.dazzle.shop.model.board.FileVO;
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
	public List<BoardVO> getBoardCateList(String ctgr_name) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardCateList(ctgr_name);
	}
	
	@Override
	public List<FileVO> getFile() {
		// TODO Auto-generated method stub
		return boardDAO.getFile();
	}
	
	@Override
	public List<FileVO> getFileList(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getFileList(vo);
	}

	@Override
	public List<BoardVO> getNoticeList(int pageNum) {
		// TODO Auto-generated method stub
		return boardDAO.getNoticeList(pageNum);
	}
	
	@Override
	public Integer getNoticeTotalPage() {
		// TODO Auto-generated method stub
		return boardDAO.getNoticeTotalPage();
	}
	
	@Override
	public List<BoardVO> getQuestList(int pageNum) {
		// TODO Auto-generated method stub
		return boardDAO.getQuestList(pageNum);
	}
	
	@Override
	public Integer getQuestTotalPage() {
		// TODO Auto-generated method stub
		return boardDAO.getQuestTotalPage();
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(vo);
	}
	
	@Override
	public CateVO getCate(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getCate(vo);
	}
	
	@Override
	public BoardProCodeVO getCode(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getCode(vo);
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
	public void fileUpload(MultipartFile file) {
		// TODO Auto-generated method stub
		boardDAO.fileUpload(file);
	}
	
	@Override
	public void insertCate(CateVO vo) {
		// TODO Auto-generated method stub
		boardDAO.insertCate(vo);
	}
	
	@Override
	public void insertNullCate(CateVO vo) {
		// TODO Auto-generated method stub
		boardDAO.insertNullCate(vo);
	}
	
	@Override
	public void insertProduct_code(BoardProCodeVO vo) {
		// TODO Auto-generated method stub
		boardDAO.insertProduct_code(vo);
	}
	
	@Override
	public void writeReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		boardDAO.writeReply(vo);
	}
	
	@Override
	public Integer ckQuestReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.ckQuestReply(vo);
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
	public void deleteQuestReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteQuestReply(vo);
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
	public void editBoardNoTag(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.editBoardNoTag(vo);
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
