package com.api.api.comment.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.api.comment.CommentForm;
import com.api.api.comment.service.CommentService;

@Controller("commentController")
public class CommentControllerImpl implements CommentController{
	
	@Autowired
	private CommentService commentService;
	
	@Override
	@RequestMapping(value = "/board_comment" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity commentinsert(
			@RequestBody CommentForm commentform
			) throws Exception {
		// 댓글 추가할떄 필요한거 생각해서 넣을것 대댓글 코멘트 카운트 추가 및 분리
		Integer Pa_comment_id = commentform.getPa_comment_id();
		System.out.println(Pa_comment_id);
		if (Pa_comment_id == null) {
			return new ResponseEntity(commentService.commentinsert(commentform), HttpStatus.OK);
		}
		return new ResponseEntity(commentService.pacommentinsert(commentform), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board_comment" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity commentlist() throws Exception {
		
		return new ResponseEntity(commentService.commentlist(), HttpStatus.OK);
	}





}
