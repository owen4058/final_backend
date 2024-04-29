package com.api.api.board.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;

@Repository("boardRepository")
public class BoardRepositoryImpl implements BoardRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardForm> homelist(int page) {
		return sqlSession.selectList("mapper.board.homelist", page);
	}
	@Override
	public List<BoardForm> boardlist(int user_id) {
		return sqlSession.selectList("mapper.board.boardlist", user_id);
	}
}
