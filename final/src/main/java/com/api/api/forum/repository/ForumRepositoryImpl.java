package com.api.api.forum.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
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
	public int forumcreate(ForumAdmin forumAdmin) {
		return sqlSession.insert("mapper.forum.form_create", forumAdmin);
	}
	
	@Override
	public int sectioncreate(SectionAdmin sectionAdmin) {
		return sqlSession.insert("mapper.forum.section_create", sectionAdmin);
	}
	
	@Override
	public List<ForumForm> forumlist() {
		return sqlSession.selectList("mapper.forum.formlist");
	}


}
