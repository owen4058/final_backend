package com.api.api.comment.service;

import java.util.List;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentUpdateForm;

public interface CommentService {
//	public List<CommentForm> commentinsert(CommentForm commentform);
	public List<CommentForm> commentinsert(CommentForm commentform);
	public List<CommentForm> commentlist();
	public List<CommentForm> recomment(int comment_id);
	public int commentupdate(CommentUpdateForm commentUpdateForm);
	public int commentdelete(int comment_id);
}
