package com.api.api.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.BoardLike;
import com.api.api.board.BoardSave;
import com.api.api.board.Hashtag;

public interface BoardController {
	public ResponseEntity<List<BoardForm>> homelist(Integer page)
			throws Exception;

	public ResponseEntity<List<BoardForm>> boardlist(Integer page, Integer forum_id, Integer section_id, Integer user_id) throws Exception;
	
	public ResponseEntity<?> boardcreate(BoardCreateForm boardCreageForm, 
			List<Hashtag> hashtag,
			MultipartFile[] boFiles,
			HttpServletRequest request) throws Exception;
	
	public ResponseEntity<?> boarddetail(
			Integer board_id
			,Integer user_id
			) throws Exception;

	public ResponseEntity<?> boardupdate(
			BoardCreateForm boardCreageForm, 
			int my_id,
			List<Hashtag> hashtag,
			List<BoardImg> boardImgs,
			MultipartFile[] boFiles
			,HttpServletRequest request) throws Exception;

	public ResponseEntity<?> boarddelete(Integer board_id) throws Exception;

	public ResponseEntity<?> boardlike(BoardLike board) throws Exception;

	public ResponseEntity<?> boardsave(BoardSave board) throws Exception;

//	public ResponseEntity<String> good(MultipartFile[] files) throws Exception;

//	public void info(MultipartFile[] files)
//			throws Exception;
}
