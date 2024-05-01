package com.api.api.comment.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.comment.CommentForm;
import com.api.api.comment.service.CommentService;

@Controller("commentController")
public class CommentControllerImpl implements CommentController{
	
	@Autowired
	private CommentService commentService;
	
	@Override
	@RequestMapping(value = "/board_comment" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<List<?>> commentinsert(
			@RequestBody CommentForm commentform
			) throws Exception {
//		Integer Pa_comment_id = commentform.getPa_comment_id();
//		if (Pa_comment_id == null) {
//			return new ResponseEntity<List<?>>(commentService.commentinsert(commentform), HttpStatus.OK);
//		}
		return new ResponseEntity<List<?>>(commentService.commentinsert(commentform), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board_comment" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<?>> commentlist() throws Exception {
		
		return new ResponseEntity<List<?>>(commentService.commentlist(), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/recomment" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<?> recomment(
			@RequestParam int comment_id
			) throws Exception {
		
		return new ResponseEntity<List<?>>(commentService.recomment(comment_id), HttpStatus.OK);
	}





}
