package com.api.api.board.repository;

import java.util.List;
import java.util.Map;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardDetailForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.BoardLike;
import com.api.api.board.BoardSave;
import com.api.api.board.Hashtag;

public interface BoardRepository {
	public List<BoardForm> homelist(Map<String, Object> mapvo);

	public List<BoardForm> boardlist(Map<String, Object> mapvo);
	
	public int boardcreate(BoardCreateForm boardCreateForm);

	public int tagcreate(List<Hashtag> hashtag);

	public int imgcreate(List<BoardImg> boardImgs);
	
	public List<BoardDetailForm> boarddetail(Map<String, Object> boardinfo);

	public List<BoardImg> boardcheck(BoardCreateForm board, List<BoardImg> img);

	public int boardupdate(BoardCreateForm board);

	public int imgdelete(BoardImg boardImg);

	public int tagdelete(int board_id);

	public int boarddelete(int board_id);

	public int boardlike(BoardLike boardLike);

	public int boardsave(BoardSave boardSave);

	public BoardLike boardlikecheck(BoardLike boardLike);

	public int boardlikepl(BoardLike boardLike);
	
	public int boardlikepl2(BoardLike boardLike);
	
	public int boardlikemi(BoardLike boardLike);
	
	public int boardlikemi2(BoardLike boardLike);

	public int boardlikedelete(BoardLike boardLike);

	public int boardlikesetpl(BoardLike boardLike);
	
	public int boardlikesetmi(BoardLike boardLike);
	
	public int boardsavedelete(Map<String, Object> vo);
	
	

}
