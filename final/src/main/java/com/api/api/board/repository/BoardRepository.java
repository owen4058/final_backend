package com.api.api.board.repository;

import java.util.List;
import java.util.Map;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;

public interface BoardRepository {
	public List<BoardForm> homelist(int page);

	public List<BoardForm> boardlist(Map<String, Object> mapvo);
	
	public int boardcreate(BoardCreateForm boardCreateForm, List<BoardImg> boardImgs);

}
