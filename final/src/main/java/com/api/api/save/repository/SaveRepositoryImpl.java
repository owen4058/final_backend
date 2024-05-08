package com.api.api.save.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.api.api.save.Save;

@Repository("saveRepository")
public class SaveRepositoryImpl implements SaveRepository{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertSavedBoard(Save save) {
		return sqlSession.insert("mapper.save.insertSavedBoard", save);
	}

	@Override
	public int deleteSavedBoard(Save save) {
		return sqlSession.insert("mapper.save.deleteSavedBoard", save);
	}

}
