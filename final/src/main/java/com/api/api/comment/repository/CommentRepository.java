package com.api.api.comment.repository;

import java.util.List;
import java.util.Map;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentLike;
import com.api.api.comment.CommentUpdateForm;

public interface CommentRepository {
//	public int commentinsert(CommentForm commentform);
	public int commentinsert(CommentForm commentform);
	public List<CommentForm> commentlist();
	public List<CommentForm> recomment(Map<String, Object> commentinfo);
	public int commentupdate(CommentUpdateForm commentUpdateForm);
	public int commentdelete(int comment_id);
	public int commentcountmi(int board_id);
	public int pacommentcountmi(int pa_comment_id);
	public int commentlike(CommentLike commentLike);
	public CommentLike commentlikecheck(CommentLike commentLike);
	public int commentlikepl(CommentLike commentLike);
	public int commentlikepl2(CommentLike commentLike);
	public int commentlikemi(CommentLike commentLike);
	public int commentlikemi2(CommentLike commentLike);
	public int commentlikedelete(CommentLike commentLike);
	public int commentlikesetpl(CommentLike commentLike);
	public int commentlikesetmi(CommentLike commentLike);

}
