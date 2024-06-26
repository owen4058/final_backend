package com.api.api.comment.controller;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentLike;
import com.api.api.comment.CommentUpdateForm;

public interface CommentController {
	
	public ResponseEntity<List<CommentForm>> commentinsert(
			CommentForm commentform
			)
			throws Exception;
	public ResponseEntity<List<CommentForm>> commentlist() throws Exception;
	public ResponseEntity<?> recomment(int comment_id, int user_id) throws Exception;
	public ResponseEntity<?> commentupdate(CommentUpdateForm commentUpdateForm) throws Exception;
	public ResponseEntity<?> commentdelete(int comment_id,int board_id , int pa_comment_id) throws Exception;
	public ResponseEntity<?> commentlike(CommentLike commentLike) throws Exception;
	public ResponseEntity<List<CommentForm>> comment(
			int board_id
			,int user_id
			) throws Exception;
}
