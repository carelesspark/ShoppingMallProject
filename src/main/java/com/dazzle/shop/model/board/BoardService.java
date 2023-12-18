package com.dazzle.shop.model.board;

import java.util.List;

public interface BoardService {
	List<BoardVO> getBoardList();
	
	BoardVO getBoard(BoardVO vo);
}
