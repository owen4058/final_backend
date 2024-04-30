package com.api.api.my.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.api.api.board.BoardForm;

@Repository("myRepository")
public class MyRepositoryImpl implements MyRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardForm> selectMyBoardList(int user_id){
		try {
            return sqlSession.selectList("mapper.my.myBoardList", user_id);
        } catch (Exception e) {
            throw new DataAccessException("게시글 목록 조회 중 오류가 발생했습니다.", e) {};
        }
		
	}
	public List<BoardForm> selectCommentMyBoardList(int user_id){
		try {
            return sqlSession.selectList("mapper.my.myCommentBoardList", user_id);
        } catch (Exception e) {
            throw new DataAccessException("게시글 목록 조회 중 오류가 발생했습니다.", e) {};
        }
	}
	public List<BoardForm> selectLikedMyBoardList(int user_id){
		try {
            return sqlSession.selectList("mapper.my.myLikedBoardList", user_id);
        } catch (Exception e) {
            throw new DataAccessException("게시글 목록 조회 중 오류가 발생했습니다.", e) {};
        }
	}
	public List<BoardForm> selectSavedMyBoardList(int user_id){
		try {
            return sqlSession.selectList("mapper.my.mySavedBoardList", user_id);
        } catch (Exception e) {
            throw new DataAccessException("게시글 목록 조회 중 오류가 발생했습니다.", e) {};
        }
	}
}
