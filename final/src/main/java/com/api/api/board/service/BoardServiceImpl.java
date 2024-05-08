package com.api.api.board.service;

import java.util.HashMap;
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
		BoardLike check;
		try {
			check = boardRepository.boardlikecheck(boardLike);
		} catch (Exception e) {
			check = null;
		}
		
		
		
		// 좋아요를 눌렀을때
		if (boardLike.getLike_ud() == 1) {
			// 이미 좋아요가 눌러져있을경우
			if (check != null) {
				// 기존의 좋아요가 1일 경우
				if (check.getLike_ud() == 1) {
					// 좋아요는 두번 불가능합니다.
					return 0;
				}else {
					//기존의 좋아요가 -1일 경우
					System.out.println("좋아요 눌렀을떄 기존값이 -1일경우 : 시작");
					boardRepository.boardlikesetpl(boardLike);
					return boardRepository.boardlikepl2(boardLike);
				}
			// 좋아요가 눌러져 있지 않은경우	
			}else {
				System.out.println("좋아요 눌렀을떄 기존값이 없을경우 : 시작");
				return boardRepository.boardlike(boardLike);
			}
		// 싫어요를 눌렀을때
		}else if(boardLike.getLike_ud() == -1){
			// 이미 좋아요가 눌러져있을경우
			if (check != null) {
				// 기존의 좋아요가 1일 경우
				if (check.getLike_ud() == 1) {
					System.out.println("싫어요 눌렀을떄 기존값이 +1일 경우 : 시작");
					boardRepository.boardlikesetmi(boardLike);
					return boardRepository.boardlikemi2(boardLike);
					
				}else {
					//기존의 좋아요가 -1일 경우
					// 싫어요는 두번 불가능합니다
					return 2;
				}
			// 좋아요가 눌러져 있지 않은경우	
			}else {
				System.out.println("싫어요 눌렀을떄 기존값이 없을경우 : 시작");
				return boardRepository.boardlike(boardLike);
			}
		// 좋아요 없음 상태가 왔을떄	
		}else {
			// 이미 좋아요가 눌러져있을경우
			if (check != null) {
				// 기존의 좋아요가 1일 경우
				if (check.getLike_ud() == 1) {
					System.out.println("상태없음을 눌렀을떄 기존값이 +1일 경우 : 시작");
					boardRepository.boardlikedelete(boardLike);
					return boardRepository.boardlikemi(boardLike);
				}else {
					//기존의 좋아요가 -1일 경우
					System.out.println("상태없음을 눌렀을떄 기존값이 -1일 경우 : 시작");
					boardRepository.boardlikedelete(boardLike);
					return boardRepository.boardlikepl(boardLike);
				}
			// 좋아요가 눌러져 있지 않은경우	
			}else {
				// 뭐임?
				return 3;
			}
		}
		
		
	}

	@Override
	public int boardsave(BoardSave boardSave) {
		return boardRepository.boardsave(boardSave);
	}

}
