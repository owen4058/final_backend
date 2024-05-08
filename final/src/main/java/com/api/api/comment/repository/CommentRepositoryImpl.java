package com.api.api.comment.repository;

import java.util.List;
import java.util.Map;

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
	public List<CommentForm> recomment(Map<String, Object> commentinfo) {
		return sqlSession.selectList("mapper.comment.recomment", commentinfo);
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
	
	// 코멘트 좋아요 관련
	
	@Override
	public CommentLike commentlikecheck(CommentLike commentLike) {
		return sqlSession.selectOne("mapper.comment.commentlikecheck",commentLike);
	}
	
	@Override
	public int commentlikepl(CommentLike commentLike) {
		return sqlSession.update("mapper.comment.commentlikeplcount",commentLike);
	}
	@Override
	public int commentlikepl2(CommentLike commentLike) {
		return sqlSession.update("mapper.comment.commentlikeplcount2",commentLike);
	}
	
	@Override
	public int commentlikemi(CommentLike commentLike) {
		return sqlSession.update("mapper.comment.commentlikedscount",commentLike);
	}
	@Override
	public int commentlikemi2(CommentLike commentLike) {
		return sqlSession.update("mapper.comment.commentlikedscount2",commentLike);
	}
	
	@Override
	public int commentlikedelete(CommentLike commentLike) {
		return sqlSession.delete("mapper.comment.commentlikedelete",commentLike);
	}
	
	@Override
	public int commentlikesetpl(CommentLike commentLike) {
		return sqlSession.update("mapper.comment.commentlikesetpl",commentLike);
	}
	@Override
	public int commentlikesetmi(CommentLike commentLike) {
		return sqlSession.update("mapper.comment.commentlikesetmi",commentLike);
	}
	


}
