package com.api.api.my.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.board.BoardForm;
import com.api.api.my.service.MyService;

@Controller("myController")
public class MyControllerImpl implements MyController {
	
	@Autowired
	private MyService myService;
	
	@RequestMapping(value = "/profile/My_Board", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<List<BoardForm>> getMyBoardlist(@RequestParam int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		System.out.println("getMyBoardList controller");
		List<BoardForm> boardList = myService.getMyBoardList(user_id);
        if (boardList != null && !boardList.isEmpty()) {
            return ResponseEntity.ok(boardList);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	@RequestMapping(value = "/profile/written_comment", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<List<BoardForm>> getCommentMyBoardlist(@RequestParam int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		System.out.println("getCommenMyBoardList controller");
		List<BoardForm> boardList = myService.getCommentMyBoardList(user_id);
//        if (boardList != null && !boardList.isEmpty()) {
            return ResponseEntity.ok(boardList);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
	}
	@RequestMapping(value = "/profile/liked_board", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<List<BoardForm>> getLikeMyBoardlist(@RequestParam int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		System.out.println("getLikedMyBoardList controller");
		List<BoardForm> boardList = myService.getLikedMyBoardList(user_id);
        if (boardList != null && !boardList.isEmpty()) {
            return ResponseEntity.ok(boardList);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	@RequestMapping(value = "/profile/saved_board", produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<List<BoardForm>> getSaveMyBoardlist(@RequestParam int user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		System.out.println("getSavedMyBoardList controller");
		List<BoardForm> boardList = myService.getSavedMyBoardList(user_id);
        if (boardList != null && !boardList.isEmpty()) {
            return ResponseEntity.ok(boardList);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
}
