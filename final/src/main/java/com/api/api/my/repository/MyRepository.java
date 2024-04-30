package com.api.api.my.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.board.BoardForm;

public interface MyRepository {
	public List<BoardForm> selectMyBoardList(int user_id) throws DataAccessException;
	public List<BoardForm> selectCommentMyBoardList(int user_id) throws DataAccessException;
	public List<BoardForm> selectLikedMyBoardList(int user_id) throws DataAccessException;
	public List<BoardForm> selectSavedMyBoardList(int user_id) throws DataAccessException;
}
