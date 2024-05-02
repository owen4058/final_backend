package com.api.api.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;

public interface BoardController {
	public ResponseEntity<List<BoardForm>> homelist(Integer page)
			throws Exception;

	public ResponseEntity<List<BoardForm>> boardlist(Integer page, Integer forum_id, Integer section_id, Integer user_id) throws Exception;
	
	public ResponseEntity<?> boardcreate(BoardCreateForm boardCreageForm, 
			List<Hashtag> hashtag,
			MultipartFile[] boFiles) throws Exception;
	
	public ResponseEntity<?> boarddetail(
			Integer board_id
			,Integer user_id
			) throws Exception;

	public ResponseEntity<?> boardupdate(
			BoardCreateForm boardCreageForm, 
			int my_id,
			List<Hashtag> hashtag,
			List<BoardImg> boardImgs,
			MultipartFile[] boFiles) throws Exception;
	
	
}
