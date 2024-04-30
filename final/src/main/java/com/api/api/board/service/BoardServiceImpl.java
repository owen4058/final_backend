package com.api.api.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardDetailForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
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
	public BoardCreateForm boardcreate(BoardCreateForm boardCreateForm, List<BoardImg> boardImgs, List<Hashtag> hashtag) {
		boardRepository.boardcreate(boardCreateForm);
		
		if (!hashtag.isEmpty()) {
			System.out.println("Ω√¿€");
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
		
		return boardCreateForm;
	}

	@Override
	public List<BoardDetailForm> boarddetail(Map<String, Object> boardinfo) {
		return boardRepository.boarddetail(boardinfo);
	}

}
