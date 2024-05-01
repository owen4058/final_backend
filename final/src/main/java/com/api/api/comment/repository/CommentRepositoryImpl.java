package com.api.api.comment.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.comment.CommentForm;

@Repository("commentRepository")
public class CommentRepositoryImpl implements CommentRepository{
	
	@Autowired
	private SqlSession sqlSession;

//	@Override
//	public int commentinsert(CommentForm commentform) {
//		sqlSession.insert("mapper.comment.commentinsert", commentform);
//		return sqlSession.update("mapper.comment.commentcount", commentform.getBoard_id());
//	}

	@Override
	public List<CommentForm> commentlist() {
		return sqlSession.selectList("mapper.comment.commentlist");
	}

	@Override
	public int commentinsert(CommentForm commentform) {
		sqlSession.insert("mapper.comment.commentinsert", commentform);
		sqlSession.insert("mapper.comment.pacommentcount", commentform);
		return sqlSession.update("mapper.comment.commentcount", commentform.getBoard_id());
	}
	@Override
	public List<CommentForm> recomment(int comment_id) {
		return sqlSession.selectList("mapper.comment.recomment", comment_id);
	}


}
