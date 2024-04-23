package com.api.api.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.board.BoardForm;
import com.api.api.board.service.BoardService;

@Controller("boardController")
public class BoardControllerImpl implements BoardController{
	
	@Autowired
	private BoardService boardService;
	
	@Override
	@RequestMapping(value = "/home" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<BoardForm>> boardlist(@RequestParam(defaultValue = "1") Integer page, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		List<BoardForm> vo = boardService.homelist(page);
		
		return new ResponseEntity<List<BoardForm>>(vo, HttpStatus.OK);
	}

}
