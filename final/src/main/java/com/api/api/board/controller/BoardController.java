package com.api.api.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.api.api.board.BoardForm;

public interface BoardController {
	public ResponseEntity<List<BoardForm>> homelist(Integer page, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;

	public ResponseEntity<List<BoardForm>> boardlist(Integer page, Integer forum_id, Integer section_id, Integer user_id, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception;
}
