package com.api.api.board.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardDetailForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.BoardLike;
import com.api.api.board.BoardSave;
import com.api.api.board.Hashtag;
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
	public List<BoardForm> boardlist(Map<String, Object> mapvo) {
		return boardRepository.boardlist(mapvo);
	}

	@Override
	public List<BoardDetailForm> boardcreate(BoardCreateForm boardCreateForm, List<BoardImg> boardImgs, List<Hashtag> hashtag) {
		boardRepository.boardcreate(boardCreateForm);
		
		if (!hashtag.isEmpty()) {
			for (int i=0; i<hashtag.size(); i++) {
				hashtag.get(i).setBoard_id(boardCreateForm.getBoard_id());
			}
			boardRepository.tagcreate(hashtag);
		}
		
		if (!boardImgs.isEmpty()) {
			for (int i=0; i<boardImgs.size(); i++) {
				boardImgs.get(i).setBoard_id(boardCreateForm.getBoard_id());
			}
			boardRepository.imgcreate(boardImgs);
		}
		Map<String, Object> boardinfo = new HashMap<>();
		
		boardinfo.put("board_id", boardCreateForm.getBoard_id());
		boardinfo.put("user_id", boardCreateForm.getUser_id());
		return boardRepository.boarddetail(boardinfo);
	}

	@Override
	public List<BoardDetailForm> boarddetail(Map<String, Object> boardinfo) {
		return boardRepository.boarddetail(boardinfo);
	}

	@Override
	public List<BoardDetailForm> boardupdate(BoardCreateForm board, List<BoardImg> img, int my_id, List<Hashtag> hashtag) {
		Map<String, Object> boardinfo = new HashMap<>();
		
		boardinfo.put("board_id", board.getBoard_id());
		boardinfo.put("user_id", my_id);
		
		
		boardRepository.boardupdate(board);
		boardRepository.tagdelete(board.getBoard_id());
		if (!hashtag.isEmpty()) {
			for (int i=0; i<hashtag.size(); i++) {
				hashtag.get(i).setBoard_id(board.getBoard_id());
			}
			boardRepository.tagcreate(hashtag);
		}
		
		
		if (!img.isEmpty()) {
			for (int i=0; i<img.size(); i++) {
				img.get(i).setBoard_id(board.getBoard_id());
			}
			boardRepository.imgcreate(img);
		}
		
		return boardRepository.boarddetail(boardinfo);

	}
	@Override
	public List<BoardImg> boardcheck(BoardCreateForm board, List<BoardImg> img) {
		return boardRepository.boardcheck(board, img);
		
	}

	@Override
	public int imgdelete(BoardImg boardImg) {
		return boardRepository.imgdelete(boardImg);
	}

	@Override
	public int boarddelete(int board_id) {
		return boardRepository.boarddelete(board_id);
	}

	@Override
	public int boardlike(BoardLike boardLike) {
		return boardRepository.boardlike(boardLike);
	}

	@Override
	public int boardsave(BoardSave boardSave) {
		return boardRepository.boardsave(boardSave);
	}

}
