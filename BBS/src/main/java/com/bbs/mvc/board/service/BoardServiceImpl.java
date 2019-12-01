package com.bbs.mvc.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbs.mvc.board.dao.BoardDAO;
import com.bbs.mvc.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Resource
	private BoardDAO boardDAO;
	
	public BoardDAO getBoardDAO() {
		return boardDAO;
	}
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public List<BoardVO> list(){
		return boardDAO.list();
	}
	
	@Override
	public int delete(BoardVO boardVO) {
		return boardDAO.delete(boardVO);
	}
	
	@Override
	public int edit(BoardVO boardVO) {
		return boardDAO.update(boardVO);
	}
	
	@Override
	public void write(BoardVO boardVO) {
		boardDAO.insert(boardVO);
	}
	
	@Override
	public BoardVO read(int seq) {
		boardDAO.updateReadCount(seq);
		return boardDAO.select(seq);
	}
}
