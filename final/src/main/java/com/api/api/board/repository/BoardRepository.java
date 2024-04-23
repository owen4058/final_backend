package com.api.api.board.repository;

import java.util.List;

import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;

public interface BoardRepository {
	public List<BoardForm> homelist(int page);

	public List<BoardImg> boardimg();

}
