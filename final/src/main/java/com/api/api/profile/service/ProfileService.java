package com.api.api.profile.service;


import org.springframework.dao.DataAccessException;

import com.api.api.profile.Profile;
import com.api.api.profile.UserFollow;

public interface ProfileService {
	public Profile getProfile(int user_id) throws DataAccessException;
	public int updateProfile(Profile profile) throws DataAccessException;
	public boolean isNicknameAvailable(String nickname) throws DataAccessException;
	public boolean followUser(UserFollow userFollow) throws DataAccessException;
	public boolean unfollowUser(UserFollow userFollow) throws DataAccessException;
}
