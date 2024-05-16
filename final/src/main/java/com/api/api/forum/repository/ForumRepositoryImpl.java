package com.api.api.forum.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.forum.ForumForm;


@Repository("forumRepository")
public class ForumRepositoryImpl implements ForumRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ForumForm> forumselect(Map<String, Object> data) {
		return sqlSession.selectList("mapper.forum.forumselect", data);
	}
	
	@Override
	public List<ForumForm> forumlist() {
		return sqlSession.selectList("mapper.forum.formlist");
	}


}
