package com.api.api.comment.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.comment.CommentForm;
import com.api.api.comment.CommentLike;
import com.api.api.comment.CommentUpdateForm;

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
	
	@Override
	public int commentupdate(CommentUpdateForm commentUpdateForm) {
		return sqlSession.update("mapper.comment.commentupdate", commentUpdateForm);
	}
	@Override
	public int commentdelete(int comment_id) {
		return sqlSession.update("mapper.comment.commentdelete", comment_id);
	}
	@Override
	public int commentcountmi(int board_id) {
		return sqlSession.update("mapper.comment.commentcountmi", board_id);
	}
	@Override
	public int pacommentcountmi(int pa_comment_id) {
		return sqlSession.update("mapper.comment.pacommentcountmi", pa_comment_id);
	}
	@Override
	public int commentlike(CommentLike commentLike) {
		sqlSession.update("mapper.comment.commentlike", commentLike);
		return sqlSession.insert("mapper.comment.commentlikeinsert", commentLike);
	}


}
