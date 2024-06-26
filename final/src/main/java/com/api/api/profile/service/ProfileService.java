package com.api.api.profile.service;


import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.profile.FollowerForm;
import com.api.api.profile.FollowingForm;
import com.api.api.profile.Profile;
import com.api.api.profile.ProfileImg;
import com.api.api.profile.UserFollow;

public interface ProfileService {
	public Profile getProfile(int user_id) throws DataAccessException;
	public int updateProfile(Profile profile, ProfileImg profileImg) throws DataAccessException;
	public boolean isNicknameAvailable(String nickname) throws DataAccessException;
	public boolean followUser(UserFollow userFollow) throws DataAccessException;
	public boolean unfollowUser(UserFollow userFollow) throws DataAccessException;
	public boolean checkUserFollow(UserFollow userFollow) throws DataAccessException;
	public List<FollowerForm> Follower(int user_id) ;
	public List<FollowingForm> Following(int user_id) ;
	public ProfileImg getProfileImg(int user_id);
}
