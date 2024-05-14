package com.api.api.profile.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.board.BoardForm;
import com.api.api.profile.Profile;

public interface ProfileRepository {
	public Profile selectProfile(int user_id) throws DataAccessException;
	public int updateProfile(Profile profile) throws DataAccessException;
	public List<BoardForm> selectMyBoardList(int user_id) throws DataAccessException;
	public String findByNickname(String nickname) throws DataAccessException;
}
