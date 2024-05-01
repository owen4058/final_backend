package com.api.api.comment.repository;

import java.util.List;

import com.api.api.comment.CommentForm;

public interface CommentRepository {
//	public int commentinsert(CommentForm commentform);
	public int commentinsert(CommentForm commentform);
	public List<CommentForm> commentlist();
	public List<CommentForm> recomment(int comment_id);

}
