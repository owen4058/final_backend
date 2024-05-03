package com.api.api.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentUpdateForm;
import com.api.api.comment.repository.CommentRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;

//	@Override
//	public List<CommentForm> commentinsert(CommentForm commentform) {
//		commentRepository.commentinsert(commentform);
//		return commentRepository.commentlist();
//	}

	@Override
	public List<CommentForm> commentlist() {
		return commentRepository.commentlist();
	}

	@Override
	public List<CommentForm> commentinsert(CommentForm commentform) {
		commentRepository.commentinsert(commentform);
		return commentRepository.commentlist();
	}

	@Override
	public List<CommentForm> recomment(int comment_id) {
		return commentRepository.recomment(comment_id);
	}

	@Override
	public int commentupdate(CommentUpdateForm commentUpdateForm) {
		return commentRepository.commentupdate(commentUpdateForm);
	}

	@Override
	public int commentdelete(int comment_id) {
		return commentRepository.commentdelete(comment_id);
	}
	

}
