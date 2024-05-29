package com.api.api.board.service;

import java.util.List;
import java.util.Map;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardDetailForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.BoardLike;
import com.api.api.board.BoardSave;
import com.api.api.board.Hashtag;

public interface BoardService {
	public List<BoardForm> homelist(Map<String, Object> mapvo);

	public List<BoardForm> boardlist(Map<String, Object> mapvo);
	
	public List<BoardDetailForm> boardcreate(BoardCreateForm boardCreateForm, List<BoardImg> boardImgs, List<Hashtag> hashtag);
	
	public List<BoardDetailForm> boarddetail(Map<String, Object> boardinfo);
	
	public List<BoardDetailForm> boardupdate(BoardCreateForm board, List<BoardImg> img, int my_id, List<Hashtag> hashtag);

	public List<BoardImg> boardcheck(BoardCreateForm board, List<BoardImg> img);
	
	public int imgdelete(BoardImg boardImg);
	
	public int boarddelete(int board_id);
	
	public int boardlike(BoardLike boardLike);

	public int boardsave(BoardSave boardSave);
	
	public int boardsavedelete(Map<String, Object> vo); 
}
