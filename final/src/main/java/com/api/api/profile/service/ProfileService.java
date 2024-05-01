package com.api.api.profile.service;


import org.springframework.dao.DataAccessException;

import com.api.api.profile.Profile;

public interface ProfileService {
	public Profile getProfile(int user_id) throws DataAccessException;
	public Profile updateProfile(int user_id, Profile profile) throws DataAccessException;
//	public List<BoardForm> getMyBoardList(int user_id) throws DataAccessException;

}
