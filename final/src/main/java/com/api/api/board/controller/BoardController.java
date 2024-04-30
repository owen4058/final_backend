package com.api.api.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.Hashtag;

public interface BoardController {
	public ResponseEntity<List<BoardForm>> homelist(Integer page, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;

	public ResponseEntity<List<BoardForm>> boardlist(Integer page, Integer forum_id, Integer section_id, Integer user_id) throws Exception;
	
	public ResponseEntity boardcreate(BoardCreateForm boardCreageForm, 
			List<Hashtag> hashtag,
			MultipartFile[] boFiles) throws Exception;
}
