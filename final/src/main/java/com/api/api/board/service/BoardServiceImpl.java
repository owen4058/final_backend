package com.api.api.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.board.BoardForm;
import com.api.api.board.repository.BoardRepository;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository boardRepository;

	@Override
	public List<BoardForm> homelist(int page) {
		return boardRepository.homelist(page);
	}
	
	@Override
	public List<BoardForm> boardlist(int user_id) {
		return boardRepository.boardlist(user_id);
	}

}
