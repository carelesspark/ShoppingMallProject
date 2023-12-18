package com.dazzle.shop.model.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dazzle.shop.JDBC;
import com.dazzle.shop.model.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	public List<BoardVO> getBoardList() {
		Connection conn = JDBC.connection();
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		String sql = "select * from board order by pno desc";	
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setPno(rs.getInt("pno"));
				vo.setUserNum(rs.getInt("user_num"));
				vo.setTitle(rs.getString("title"));
				vo.setCate(rs.getString("cate"));
				vo.setPosttime(rs.getDate("posttime"));
				vo.setProductCode(rs.getInt("product_code"));
				
				boardList.add(vo);
			}
				
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardList;
	}
	
	public BoardVO getBoard(BoardVO vo) {
		Connection conn = JDBC.connection();
		
		BoardVO board = new BoardVO();
		
		String sql = "select * from board where pno = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getPno());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				board.setPno(rs.getInt("pno"));
				board.setUserNum(rs.getInt("user_num"));
				board.setTitle(rs.getString("title"));
				board.setCate(rs.getString("cate"));
				board.setPosttime(rs.getDate("posttime"));
				board.setProductCode(rs.getInt("product_code"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return board;
	}
}
