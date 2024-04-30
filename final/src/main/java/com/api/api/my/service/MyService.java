package com.api.api.my.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.board.BoardForm;

public interface MyService {
	public List<BoardForm> getMyBoardList(int user_id) throws DataAccessException;
	public List<BoardForm> getCommentMyBoardList(int user_id) throws DataAccessException;
	public List<BoardForm> getLikedMyBoardList(int user_id) throws DataAccessException;
	public List<BoardForm> getSavedMyBoardList(int user_id) throws DataAccessException;
}
