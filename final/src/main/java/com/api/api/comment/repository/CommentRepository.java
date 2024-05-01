package com.api.api.comment.repository;

import java.util.List;
import java.util.Map;

import com.api.api.admin.ForumAdmin;
import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;
import com.api.api.comment.CommentForm;

public interface CommentRepository {
	public int commentinsert(CommentForm commentform);
	public int pacommentinsert(CommentForm commentform);
	public List<CommentForm> commentlist();
	public List<CommentForm> recomment(int comment_id);

}
