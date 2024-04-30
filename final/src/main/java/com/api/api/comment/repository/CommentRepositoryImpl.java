package com.api.api.comment.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.admin.ForumAdmin;
import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;
import com.api.api.comment.CommentForm;

@Repository("commentRepository")
public class CommentRepositoryImpl implements CommentRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int commentinsert(CommentForm commentform) {
		 sqlSession.insert("mapper.comment.commentinsert", commentform);
		return sqlSession.update("mapper.comment.commentcount", commentform.getBoard_id());
	}

	@Override
	public List<CommentForm> commentlist() {
		return sqlSession.selectList("mapper.comment.commentinsert");
	}

	@Override
	public int pacommentinsert(CommentForm commentform) {
		 sqlSession.insert("mapper.comment.pacommentinsert", commentform);
		 sqlSession.insert("mapper.comment.pacommentcount", commentform.getComment_id());
		return sqlSession.update("mapper.comment.commentcount", commentform.getBoard_id());
	}


}
