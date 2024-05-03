package com.api.api.comment.repository;

import java.util.List;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentUpdateForm;

public interface CommentRepository {
//	public int commentinsert(CommentForm commentform);
	public int commentinsert(CommentForm commentform);
	public List<CommentForm> commentlist();
	public List<CommentForm> recomment(int comment_id);
	public int commentupdate(CommentUpdateForm commentUpdateForm);
	public int commentdelete(int comment_id);

}
