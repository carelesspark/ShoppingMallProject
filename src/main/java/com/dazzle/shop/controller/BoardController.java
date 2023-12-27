package com.dazzle.shop.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dazzle.shop.model.board.BoardService;
import com.dazzle.shop.model.board.BoardVO;
import com.dazzle.shop.model.board.FileVO;
import com.dazzle.shop.model.board.ReplyVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/boardMain.do")
	public String getBoardList(Model model, @RequestParam(required = false, defaultValue="0")int ctgr_num, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_num") != null) {			
			int user_num = (int) session.getAttribute("user_num");
			model.addAttribute("user_num", user_num);
		}
		
		if(ctgr_num != 0) {
			List<BoardVO> boardList = boardService.getCtgrBoardList(ctgr_num);
			
			model.addAttribute("boardList", boardList);
		} else {			
			List<BoardVO> boardList = boardService.getBoardList();
			
			model.addAttribute("boardList", boardList);
		}
		
		List<FileVO> fileList = boardService.getFileList();
		
		model.addAttribute("file", fileList);

		return "/board/boardMain.jsp";
	}

	@RequestMapping(value = "/noticeMain.do")
	public String getNoticeList(Model model, @RequestParam(defaultValue = "1") int pageNum, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_num") != null) {			
			int user_num = (int) session.getAttribute("user_num");
			model.addAttribute("user_num", user_num);
		}
		
		List<BoardVO> noticeList = boardService.getNoticeList(pageNum);

		model.addAttribute("noticeList", noticeList);

		Integer totalPage = boardService.getNoticeTotalPage();

		model.addAttribute("page", totalPage);

		System.out.println(totalPage);

		return "/board/noticeMain.jsp";
	}

	@RequestMapping(value = "/questionMain.do")
	public String getQuestList(Model model, @RequestParam(defaultValue = "1") int pageNum, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_num") != null) {			
			int user_num = (int) session.getAttribute("user_num");
			model.addAttribute("user_num", user_num);
		}
		
		List<BoardVO> questList = boardService.getQuestList(pageNum);

		model.addAttribute("questList", questList);

		Integer totalPage = boardService.getQuestTotalPage();

		model.addAttribute("page", totalPage);

		return "/board/questionMain.jsp";
	}

	@RequestMapping(value = "/boardGet.do")
	public String getBoard(BoardVO vo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_num") != null) {			
			int user_num = (int) session.getAttribute("user_num");
			model.addAttribute("user_num", user_num);
		}
		
		BoardVO board = boardService.getBoard(vo);
		List<ReplyVO> replyList = boardService.getReply(vo);

		model.addAttribute("board", board);
		model.addAttribute("replyList", replyList);

		return "/board/boardGet.jsp";
	}

	@RequestMapping(value = "/noticeGet.do")
	public String getNotice(BoardVO vo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_num") != null) {			
			int user_num = (int) session.getAttribute("user_num");
			model.addAttribute("user_num", user_num);
		}
		
		BoardVO notice = boardService.getBoard(vo);

		model.addAttribute("notice", notice);

		return "/board/noticeGet.jsp";
	}

	@RequestMapping(value = "/questionGet.do")
	public String getQuest(BoardVO vo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");
		model.addAttribute("user_num", user_num);
		
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

	@RequestMapping(value = "/board/boardWrite.do")
	public String writeBoard(BoardVO vo, HttpServletRequest request, MultipartHttpServletRequest mRequest) {
		List<MultipartFile> mainImageList = mRequest.getFiles("file");
		System.out.println(mainImageList);
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		vo.setUserNum(user_num);
		int pno = boardService.writeBoard(vo);
		System.out.println("pno: " + pno);

		String webappPath = request.getSession().getServletContext().getRealPath("/");
		String imagePath = webappPath + "resources/image/board/" + pno + "/";

		// 메인 이미지 저장 및 DB에 기록
		File directory = new File(imagePath);
		if (!directory.exists()) {
			directory.mkdirs(); // Create the directory if it doesn't exist
		}

		for (MultipartFile mainImage : mainImageList) {
			String mainImageName = mainImage.getOriginalFilename();
			String filePath = imagePath + mainImageName;

			try {
				mainImage.transferTo(new File(filePath));
				System.out.println("성공성공: " + filePath);
			} catch (IllegalStateException | IOException e) {
				System.err.println("에러에러: " + e.getMessage());
				e.printStackTrace();
			}

			boardService.insertBoardImg(pno, mainImageName);
		}

		return "redirect:/boardMain.do";

	}

	@RequestMapping(value = "/writeReply.do")
	public String writeReply(ReplyVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");
		
		vo.setUserNum(user_num);
		
		boardService.writeReply(vo);

		return "redirect:/boardGet.do?pno=" + vo.getPno();
	}

	@RequestMapping(value = "/writeQuestReply.do")
	public String writeQuestReply(ReplyVO vo) {

		if (boardService.ckQuestReply(vo) != 0) {
			boardService.deleteQuestReply(vo);
			boardService.writeReply(vo);
		} else {
			boardService.writeReply(vo);
		}

		return "redirect:/questionMain.do";
	}

	@RequestMapping(value = "/board/noticeWrite.do")
	public String writeNotice(BoardVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		vo.setUserNum(user_num);
		
		boardService.writeNotice(vo);

		return "redirect:/noticeMain.do";
	}

	@RequestMapping(value = "/board/questionWrite.do")
	public String writeQuest(BoardVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int user_num = (int) session.getAttribute("user_num");

		vo.setUserNum(user_num);
		
		boardService.writeQuest(vo);

		return "redirect:/questionMain.do";
	}

	@RequestMapping(value = "deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);

		return "redirect:/boardMain.do";
	}

	@RequestMapping(value = "deleteReply.do")
	public String deleteReply(ReplyVO vo) {

		boardService.deleteReply(vo);

		return "redirect:/boardGet.do?pno=" + vo.getPno();
	}

	@RequestMapping(value = "deleteNotice.do")
	public String deleteNotice(BoardVO vo) {
		boardService.deleteNotice(vo);

		return "redirect:/noticeMain.do";
	}

	@RequestMapping(value = "deleteQuest.do")
	public String deleteQuest(BoardVO vo) {
		boardService.deleteQuest(vo);

		return "redirect:/questionMain.do";
	}

	@RequestMapping(value = "/board/boardEdit.do")
	public String editBoard(BoardVO vo, Model model) { // 수정 내용 미리 들어가있게
		BoardVO board = boardService.getBoard(vo);

		model.addAttribute("board", board);

		return "/board/boardEdit.jsp";
	}

	@RequestMapping(value = "/board/editBoard.do")
	public String editBoard(BoardVO vo) {

		return "redirect:/boardGet.do?pno=" + vo.getPno();
	}

	@RequestMapping(value = "/board/noticeEdit.do")
	public String editNotice(BoardVO vo, Model model) { // 수정 내용 미리 들어가있게
		BoardVO notice = boardService.getNotice(vo);

		model.addAttribute("notice", notice);

		return "/board/noticeEdit.jsp";
	}

	@RequestMapping(value = "/board/editNotice.do")
	public String editNotice(BoardVO vo) {
		boardService.editNotice(vo);

		return "redirect:/noticeGet.do?pno=" + vo.getPno();
	}

	@RequestMapping(value = "/board/questionEdit.do")
	public String editQuest(BoardVO vo, Model model) { // 수정 내용 미리 들어가있게
		BoardVO quest = boardService.getQuest(vo);

		model.addAttribute("quest", quest);

		return "/board/questionEdit.jsp";
	}

	@RequestMapping(value = "/board/editQuest.do")
	public String editQuest(BoardVO vo) {
		boardService.editQuest(vo);

		return "redirect:/questionGet.do?pno=" + vo.getPno();
	}
}
