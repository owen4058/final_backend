package com.api.api.profile.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.board.BoardForm;
import com.api.api.profile.FollowerForm;
import com.api.api.profile.FollowingForm;
import com.api.api.profile.Profile;
import com.api.api.profile.ProfileImg;
import com.api.api.profile.UserFollow;

public interface ProfileRepository {
	public Profile selectProfile(int user_id) throws DataAccessException;
	public int updateProfile(Profile profile) throws DataAccessException;
	public List<BoardForm> selectMyBoardList(int user_id) throws DataAccessException;
	public String findByNickname(String nickname) throws DataAccessException;
	public int insertUserFollow(UserFollow userFollow) throws DataAccessException;
	public int deleteUserUnFollow(UserFollow userFollow) throws DataAccessException;
	public int insertImg(ProfileImg profileImg) throws DataAccessException;
	public int deleteImg(int user_id) throws DataAccessException;
	public int isFollowing(UserFollow userFollow) throws DataAccessException;
	public int hasImg(int user_id) throws DataAccessException;
	public List<FollowerForm> Follower(int user_id);
	public List<FollowingForm> Following(int user_id);
	public ProfileImg selectProfileImg(int user_id);
}
