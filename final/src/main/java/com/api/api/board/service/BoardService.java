package com.api.api.board.service;

import java.util.List;
import java.util.Map;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;

public interface BoardService {
	public List<BoardForm> homelist(int page);

	public List<BoardForm> boardlist(Map<String, Object> mapvo);
	
	public int boardcreate(BoardCreateForm boardCreateForm, List<BoardImg> boardImgs, List<Hashtag> hashtag);

}
