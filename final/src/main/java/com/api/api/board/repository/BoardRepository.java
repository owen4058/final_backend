package com.api.api.board.repository;

import java.util.List;
import java.util.Map;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardDetailForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;

public interface BoardRepository {
	public List<BoardForm> homelist(int page);

	public List<BoardForm> boardlist(Map<String, Object> mapvo);
	
	public int boardcreate(BoardCreateForm boardCreateForm);

	public int tagcreate(List<Hashtag> hashtag);

	public int imgcreate(List<BoardImg> boardImgs);
	
	public List<BoardDetailForm> boarddetail(Map<String, Object> boardinfo);

	public List<BoardImg> boardcheck(BoardCreateForm board, List<BoardImg> img);

	public int boardupdate(BoardCreateForm board);

}
