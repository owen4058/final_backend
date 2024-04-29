package com.api.api.board.service;

import java.util.List;
import java.util.Map;

import com.api.api.board.BoardForm;

public interface BoardService {
	public List<BoardForm> homelist(int page);

	public List<BoardForm> boardlist(int user_id);

}
