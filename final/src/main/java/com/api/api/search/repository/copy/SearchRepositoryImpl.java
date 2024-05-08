package com.api.api.search.repository.copy;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.board.BoardForm;
import com.api.api.forum.ForumForm;


@Repository("searchRepository")
public class SearchRepositoryImpl implements SearchRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ForumForm> searchforum(Map<String, Object> searchinfo) {
		return sqlSession.selectList("mapper.search.searchforum", searchinfo);
	}
	
	@Override
	public List<BoardForm> searchboardtitle(Map<String, Object> searchinfo) {
		return sqlSession.selectList("mapper.search.boardtitle", searchinfo);
	}
	@Override
	public List<BoardForm> searchboardcontent(Map<String, Object> searchinfo) {
		return sqlSession.selectList("mapper.search.boardcontent", searchinfo);
	}



}
