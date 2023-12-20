package com.dazzle.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dazzle.shop.model.board.BoardService;
import com.dazzle.shop.model.board.BoardVO;
import com.dazzle.shop.model.board.ReplyVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardMain.do")
	public String getBoardList(Model model) {
		List<BoardVO> boardList = boardService.getBoardList();
		
		model.addAttribute("boardList", boardList);
		
		return "/board/boardMain.jsp";
	}
	
	@RequestMapping(value="/noticeMain.do")
	public String getNoticeList(Model model) {
		List<BoardVO> noticeList = boardService.getNoticeList();
		
		model.addAttribute("noticeList", noticeList);
		
		return "/board/noticeMain.jsp";
	}
	
	@RequestMapping(value="/questionMain.do")
	public String getQuestList(Model model) {
		List<BoardVO> questList = boardService.getQuestList();
		
		model.addAttribute("questList", questList);
		
		return "/board/questionMain.jsp";
	}
	
	@RequestMapping(value="/boardGet.do")
	public String getBoard(BoardVO vo, Model model) {
		BoardVO board = boardService.getBoard(vo);
		List<ReplyVO> replyList = boardService.getReply(vo);
		
		model.addAttribute("board", board);
		model.addAttribute("replyList", replyList);
		
		return "/board/boardGet.jsp";
	}
	
	@RequestMapping(value="/noticeGet.do")
	public String getNotice(BoardVO vo, Model model) {
		BoardVO notice = boardService.getBoard(vo);
		
		model.addAttribute("notice", notice);
		
		return "/board/noticeGet.jsp";
	}
	
	@RequestMapping(value="/questionGet.do")
	public String getQuest(BoardVO vo, Model model) {
		BoardVO quest = boardService.getBoard(vo);
		try {
			ReplyVO reply = boardService.getQuestReply(vo);

			model.addAttribute("reply", reply);
		} catch (Exception e) {
			// TODO: handle exception
			ReplyVO reply = new ReplyVO();
			reply.setRcontent("아직 답변이 없습니다");
			model.addAttribute("reply", reply);
		} 
		
		model.addAttribute("quest", quest);
		
		return "/board/questionGet.jsp";
	}
	
	@RequestMapping(value="/board/boardWrite.do")
	public String writeBoard(BoardVO vo) {
		boardService.writeBoard(vo);
		
		return "redirect:/boardMain.do";
	}
	
	@RequestMapping(value="/writeReply.do")
	public String writeReply(ReplyVO vo) {
		boardService.writeReply(vo);
		
		return "redirect:/boardGet.do?pno=" + vo.getPno();
	}
	
	@RequestMapping(value="/board/noticeWrite.do")
	public String writeNotice(BoardVO vo) {
		boardService.writeNotice(vo);
		
		return "redirect:/noticeMain.do";
	}
	
	@RequestMapping(value="/board/questionWrite.do")
	public String writeQuest(BoardVO vo) {
		boardService.writeQuest(vo);
		
		return "redirect:/questionMain.do";
	}
	
	@RequestMapping(value="deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		
		return "redirect:/boardMain.do";
	}
	
	@RequestMapping(value="deleteReply.do")
	public String deleteReply(ReplyVO vo) {
		
		boardService.deleteReply(vo);
		
		return "redirect:/boardGet.do?pno=" + vo.getPno();
	}
	
	@RequestMapping(value="deleteNotice.do")
	public String deleteNotice(BoardVO vo) {
		boardService.deleteNotice(vo);
		
		return "redirect:/noticeMain.do";
	}
	
	@RequestMapping(value="deleteQuest.do")
	public String deleteQuest(BoardVO vo) {
		boardService.deleteQuest(vo);
		
		return "redirect:/questionMain.do";
	}
}
