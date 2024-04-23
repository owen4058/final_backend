package com.api.api.board.service;

import java.util.List;

import com.api.api.board.BoardForm;

public interface BoardService {
	public List<BoardForm> homelist(int page);

}
