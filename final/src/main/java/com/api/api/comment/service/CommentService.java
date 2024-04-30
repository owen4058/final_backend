package com.api.api.comment.service;

import java.util.List;
import java.util.Map;

import com.api.api.admin.ForumAdmin;
import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;
import com.api.api.comment.CommentForm;

public interface CommentService {
	public List<CommentForm> commentinsert(CommentForm commentform);
	public List<CommentForm> pacommentinsert(CommentForm commentform);
	public List<CommentForm> commentlist();
}
