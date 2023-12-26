package com.dazzle.shop.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.dazzle.shop.model.board.BoardProCodeVO;
import com.dazzle.shop.model.board.BoardService;
import com.dazzle.shop.model.board.BoardVO;
import com.dazzle.shop.model.board.CateVO;
import com.dazzle.shop.model.board.FileVO;
import com.dazzle.shop.model.board.ReplyVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardMain.do")
	public String getBoardList(Model model, @RequestParam(value = "ctgr_name", required = false)String ctgr_name) {
		if(ctgr_name == null) {
			List<BoardVO> boardList = boardService.getBoardList();
			
			model.addAttribute("boardList", boardList);
		} else if(ctgr_name != null) {
			List<BoardVO> boardList = boardService.getBoardCateList(ctgr_name);
			
			model.addAttribute("boardList", boardList);
		}
		
		List<FileVO> files = boardService.getFile();
		
		model.addAttribute("f", files);
		
		return "/board/boardMain.jsp";
	}
	
	@RequestMapping(value="/noticeMain.do")
	public String getNoticeList(Model model, @RequestParam(defaultValue="1")int pageNum) {
		List<BoardVO> noticeList = boardService.getNoticeList(pageNum);
		
		model.addAttribute("noticeList", noticeList);
		
		Integer totalPage = boardService.getNoticeTotalPage();
		
		model.addAttribute("page", totalPage);
		
		System.out.println(totalPage);
		
		return "/board/noticeMain.jsp";
	}
	
	@RequestMapping(value="/questionMain.do")
	public String getQuestList(Model model, @RequestParam(defaultValue="1")int pageNum) {
		List<BoardVO> questList = boardService.getQuestList(pageNum);
		
		model.addAttribute("questList", questList);
		
		Integer totalPage = boardService.getQuestTotalPage();
		
		model.addAttribute("page", totalPage);
		
		return "/board/questionMain.jsp";
	}
	
	@RequestMapping(value="/boardGet.do")
	public String getBoard(BoardVO vo, Model model) {
		BoardVO board = boardService.getBoard(vo);
		List<ReplyVO> replyList = boardService.getReply(vo);
		List<FileVO> fileList = boardService.getFileList(vo);
		CateVO cate = boardService.getCate(vo);
		BoardProCodeVO code = boardService.getCode(vo);
		
		model.addAttribute("board", board);
		model.addAttribute("replyList", replyList);
		model.addAttribute("fileList", fileList);
		model.addAttribute("cate", cate);
		model.addAttribute("code", code);	
		
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
			
		} 
		
		model.addAttribute("quest", quest);
		
		return "/board/questionGet.jsp";
	}
	
	@RequestMapping(value="/board/boardWrite.do")
	public String writeBoard(BoardVO vo) {
		boardService.writeBoard(vo);
				
		return "/fileUpload.do";
	}
	
	@RequestMapping(value="/fileUpload.do")
	public String fileUpload(MultipartFile file) {
		boardService.fileUpload(file);
		
		try {
			file.transferTo(new File("../resources/image/upload" + file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/insertCate.do";
	}
	
	@RequestMapping(value="/insertCate.do")
	public String insertCate(CateVO vo) {
		if(vo.getCtgr_name().equals("")) {
			boardService.insertNullCate(vo);
		} else {
			boardService.insertCate(vo);			
		}
		
		return "/insertCode.do";
	}
	
	@RequestMapping(value="/insertCode.do")
	public String insertCode(BoardProCodeVO vo) {
		
		if(vo.getProduct_code1() == 0) {
			vo.setProduct_code1(1);
		} else if(vo.getProduct_code2() == 0) {
			vo.setProduct_code2(1);
			vo.setProduct_code3(1);
			vo.setProduct_code4(1);
			vo.setProduct_code5(1);
		} else if(vo.getProduct_code3() == 0) {
			vo.setProduct_code3(1);
			vo.setProduct_code4(1);
			vo.setProduct_code5(1);
		} else if(vo.getProduct_code4() == 0) {
			vo.setProduct_code4(1);
			vo.setProduct_code5(1);
		} else if(vo.getProduct_code5() == 0) {
			vo.setProduct_code5(1);
		}
		
		boardService.insertProduct_code(vo);
		
		return "redirect:/boardMain.do";
	}
	
	@RequestMapping(value="/writeReply.do")
	public String writeReply(ReplyVO vo) {
		boardService.writeReply(vo);
		
		return "redirect:/boardGet.do?pno=" + vo.getPno();
	}
	
	@RequestMapping(value="/writeQuestReply.do")
	public String writeQuestReply(ReplyVO vo) {
		
		if(boardService.ckQuestReply(vo) != 0) {
			boardService.deleteQuestReply(vo);
			boardService.writeReply(vo);			
		} else {
			boardService.writeReply(vo);
		}
		
		return "redirect:/questionMain.do";
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
	
	@RequestMapping(value="/board/boardEdit.do")
	public String editBoard(BoardVO vo, Model model) {	// 수정 내용 미리 들어가있게
		BoardVO board = boardService.getBoard(vo);
		
		model.addAttribute("board", board);
		
		return "/board/boardEdit.jsp";
	}
	
	@RequestMapping(value="/board/editBoard.do")
	public String editBoard(BoardVO vo) {
		
		
		return "redirect:/boardGet.do?pno=" + vo.getPno();
	}
	
	@RequestMapping(value="/board/noticeEdit.do")
	public String editNotice(BoardVO vo, Model model) {	// 수정 내용 미리 들어가있게
		BoardVO notice = boardService.getNotice(vo);
		
		model.addAttribute("notice", notice);
		
		return "/board/noticeEdit.jsp";
	}
	
	@RequestMapping(value="/board/editNotice.do")
	public String editNotice(BoardVO vo) {
		boardService.editNotice(vo);
		
		return "redirect:/noticeGet.do?pno=" + vo.getPno();
	}
	
	@RequestMapping(value="/board/questionEdit.do")
	public String editQuest(BoardVO vo, Model model) {	// 수정 내용 미리 들어가있게
		BoardVO quest = boardService.getQuest(vo);
		
		model.addAttribute("quest", quest);
		
		return "/board/questionEdit.jsp";
	}
	
	@RequestMapping(value="/board/editQuest.do")
	public String editQuest(BoardVO vo) {
		boardService.editQuest(vo);
		
		return "redirect:/questionGet.do?pno=" + vo.getPno();
	}
}
