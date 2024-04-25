package com.api.api.profile.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.board.BoardForm;
import com.api.api.profile.Profile;

public interface ProfileRepository {
	public int getProfile(int user_id) throws DataAccessException;
	public Profile updateProfile(Profile profile) throws DataAccessException;
	public List<BoardForm> myBoardList(int user_id) throws DataAccessException;;
}
