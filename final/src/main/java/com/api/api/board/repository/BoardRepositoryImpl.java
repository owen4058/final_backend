package com.api.api.board.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardDetailForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;

@Repository("boardRepository")
public class BoardRepositoryImpl implements BoardRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardForm> homelist(int page) {
		return sqlSession.selectList("mapper.board.homelist", page);
	}
	@Override
	public List<BoardForm> boardlist(Map<String, Object> mapvo) {
		return sqlSession.selectList("mapper.board.boardlist", mapvo);
	}
	@Override
	public int boardcreate(BoardCreateForm boardCreateForm) {
		return sqlSession.insert("mapper.board.boardinsert",boardCreateForm);
	}
	@Override
	public int tagcreate(List<Hashtag> hashtag) {
		return sqlSession.insert("mapper.board.taginsert", hashtag);
	}
	@Override
	public int imgcreate(List<BoardImg> boardImgs) {
		return sqlSession.insert("mapper.board.imginsert",boardImgs);
	}
	@Override
	public List<BoardDetailForm> boarddetail(Map<String, Object> boardinfo) {
		sqlSession.update("mapper.board.boardhit", boardinfo);
		return sqlSession.selectList("mapper.board.board", boardinfo);
	}

}
