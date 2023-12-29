package com.dazzle.shop.model.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dazzle.shop.model.board.BoardProductVO;
import com.dazzle.shop.model.board.BoardService;
import com.dazzle.shop.model.board.BoardVO;
import com.dazzle.shop.model.board.FileVO;
import com.dazzle.shop.model.board.PVO;
import com.dazzle.shop.model.board.ReplyVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() { // 게시판 메인
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}

	@Override
	public List<FileVO> getFileList() {
		// TODO Auto-generated method stub
		return boardDAO.getFileList();
	}

	@Override
	public List<FileVO> getFileList(int ctgr_num) {
		// TODO Auto-generated method stub
		return boardDAO.getFileList(ctgr_num);
	}

	@Override
	public List<BoardVO> getCtgrBoardList(int ctgr_num) { // 게시판 카테고리별 보기
		// TODO Auto-generated method stub
		return boardDAO.getCtgrBoardList(ctgr_num);
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
	public List<FileVO> getFile(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getFile(vo);
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
	public int writeBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.writeBoard(vo);
	}

	@Override
	public List<PVO> getProductList() {
		// TODO Auto-generated method stub
		return boardDAO.getProductList();
	}

	@Override
	public void insertBoardImg(int pno, String mainImageName) {
		// TODO Auto-generated method stub
		boardDAO.insertBoardImg(pno, mainImageName);
	}

	@Override
	public void insertPNum(BoardProductVO vo) {
		// TODO Auto-generated method stub
		boardDAO.insertPNum(vo);
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
	public void updateBoardImg(int pno, String mainImageName) {
		// TODO Auto-generated method stub
		boardDAO.updateBoardImg(pno, mainImageName);
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

	//////////////////////////
	@Override
	public String getCate(int pno) {
		return boardDAO.getCate(pno);
	}
}
