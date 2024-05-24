package com.api.api.comment.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentLike;
import com.api.api.comment.CommentUpdateForm;
import com.api.api.comment.service.CommentService;

@Controller("commentController")
public class CommentControllerImpl implements CommentController{
	
	@Autowired
	private CommentService commentService;
	
	@Override
	@RequestMapping(value = "/board_comment" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<List<CommentForm>> commentinsert(
			@RequestBody CommentForm commentform
			) throws Exception {
		
//		Integer Pa_comment_id = commentform.getPa_comment_id();
//		if (Pa_comment_id == null) {
//			return new ResponseEntity<List<?>>(commentService.commentinsert(commentform), HttpStatus.OK);
//		}
		return new ResponseEntity<List<CommentForm>>(commentService.commentinsert(commentform), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board_comment" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<CommentForm>> commentlist() throws Exception {
		
		return new ResponseEntity<List<CommentForm>>(commentService.commentlist(), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/recomment" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<CommentForm>> recomment(
			@RequestParam int comment_id
			,@RequestParam int user_id
			) throws Exception {
		if (comment_id == 0) {
			comment_id = -1;
		}
		Map<String, Object> commentinfo = new HashMap<>();
		commentinfo.put("comment_id", comment_id);
		commentinfo.put("user_id", user_id);
		
		return new ResponseEntity<List<CommentForm>>(commentService.recomment(commentinfo), HttpStatus.OK);
	}
	@Override
	@RequestMapping(value = "/comment" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<CommentForm>> comment(
			@RequestParam int board_id
			,@RequestParam int user_id
			) throws Exception {
		Map<String, Object> commentinfo = new HashMap<>();
		commentinfo.put("board_id", board_id);
		commentinfo.put("user_id", user_id);
		
		return new ResponseEntity<List<CommentForm>>(commentService.comment(commentinfo), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board_comment" ,produces = "application/json; charset=utf8", method = RequestMethod.PUT)
	public ResponseEntity<Integer> commentupdate(
			@RequestBody CommentUpdateForm commentUpdateForm
			) throws Exception {
		
		return new ResponseEntity<Integer>(commentService.commentupdate(commentUpdateForm), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/board_comment" ,produces = "application/json; charset=utf8", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> commentdelete(
			@RequestParam int comment_id
			,@RequestParam int board_id
			,@RequestParam(required = false) int pa_comment_id
			) throws Exception {
		

		return new ResponseEntity<Integer>(commentService.commentdelete(comment_id, board_id ,pa_comment_id), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/comment_like" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<String> commentlike(
			@RequestBody CommentLike commentLike
			) throws Exception {
		int result = commentService.commentlike(commentLike);
		
		if (result == 1) {
			return new ResponseEntity<String>("정상입력 됐습니다.", HttpStatus.OK);
		}else if (result == 2) {
			return new ResponseEntity<String>("싫어요는 두번 이상 불가능합니다.", HttpStatus.BAD_REQUEST);
		}else if (result == 3) {
			return new ResponseEntity<String>("입력오류입니다.", HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<String>("좋아요는 두번 이상 불가능합니다.", HttpStatus.BAD_REQUEST);
		}
	}





}
