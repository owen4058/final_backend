package com.api.api.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.admin.ForumAdmin;
import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.Hashtag;
import com.api.api.comment.CommentForm;

public interface CommentController {
	
	public ResponseEntity adminforumcreate(
			CommentForm commentform
			)
			throws Exception;

}
