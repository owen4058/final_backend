package com.api.api.my.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.api.board.BoardForm;

public interface MyController {
	public ResponseEntity<List<BoardForm>> getMyBoardlist(@RequestBody int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;
	public ResponseEntity<List<BoardForm>> getCommentMyBoardlist(@RequestBody int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;
	public ResponseEntity<List<BoardForm>> getLikeMyBoardlist(@RequestBody int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;
	public ResponseEntity<List<BoardForm>> getSaveMyBoardlist(@RequestBody int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;
	
}
