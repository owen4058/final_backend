package com.api.api.comment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.repository.AdminRepository;
import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;
import com.api.api.board.repository.BoardRepository;
import com.api.api.comment.CommentForm;
import com.api.api.comment.repository.CommentRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<CommentForm> commentinsert(CommentForm commentform) {
		commentRepository.commentinsert(commentform);
		System.out.println("½Ãµµ3");
		return commentRepository.commentlist();
	}

	@Override
	public List<CommentForm> commentlist() {
		return commentRepository.commentlist();
	}

	@Override
	public List<CommentForm> pacommentinsert(CommentForm commentform) {
		commentRepository.pacommentinsert(commentform);
		return commentRepository.commentlist();
	}

}
