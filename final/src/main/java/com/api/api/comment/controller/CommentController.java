package com.api.api.comment.controller;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.api.comment.CommentForm;

public interface CommentController {
	
	public ResponseEntity<List<?>> commentinsert(
			CommentForm commentform
			)
			throws Exception;
	public ResponseEntity<?> commentlist() throws Exception;
	public ResponseEntity<?> recomment(int comment_id) throws Exception;
}
