package com.api.api.comment.repository;

import java.util.List;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentLike;
import com.api.api.comment.CommentUpdateForm;

public interface CommentRepository {
//	public int commentinsert(CommentForm commentform);
	public int commentinsert(CommentForm commentform);
	public List<CommentForm> commentlist();
	public List<CommentForm> recomment(int comment_id);
	public int commentupdate(CommentUpdateForm commentUpdateForm);
	public int commentdelete(int comment_id);
	public int commentcountmi(int board_id);
	public int pacommentcountmi(int pa_comment_id);
	public int commentlike(CommentLike commentLike);

}
