package com.api.api.comment.service;

import java.util.List;
import java.util.Map;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentLike;
import com.api.api.comment.CommentUpdateForm;

public interface CommentService {
//	public List<CommentForm> commentinsert(CommentForm commentform);
	public List<CommentForm> commentinsert(CommentForm commentform);
	public List<CommentForm> commentlist();
	public List<CommentForm> recomment(Map<String, Object> commentinfo);
	public int commentupdate(CommentUpdateForm commentUpdateForm);
	public int commentdelete(int comment_id, int board_id , int pa_comment_id);
	public int commentlike(CommentLike commentLike);
}
