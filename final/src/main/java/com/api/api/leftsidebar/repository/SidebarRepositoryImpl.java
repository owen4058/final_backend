package com.api.api.leftsidebar.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.leftsidebar.FavoriteForum;

@Repository("sidebarRepository")
public class SidebarRepositoryImpl implements SidebarRepository{
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<FavoriteForum> formlist(Map<String, Object> data) {
		return sqlsession.selectList("mapper.leftsidebar.favoriteforumlist",data);
	}

}
