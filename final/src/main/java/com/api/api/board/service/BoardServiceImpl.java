package com.api.api.board.service;

import java.util.List;

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

}
