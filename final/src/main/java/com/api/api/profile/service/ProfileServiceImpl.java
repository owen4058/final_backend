package com.api.api.profile.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.api.api.board.repository.BoardRepository;
import com.api.api.profile.FollowerForm;
import com.api.api.profile.FollowingForm;
import com.api.api.profile.Profile;
import com.api.api.profile.ProfileImg;
import com.api.api.profile.UserFollow;
import com.api.api.profile.repository.ProfileRepository;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
    public Profile getProfile(int user_id) throws DataAccessException {
        return profileRepository.selectProfile(user_id);
    }

    @Override
    public int updateProfile(Profile profile, ProfileImg profileImg) throws DataAccessException {
        int updatedRows_profile = profileRepository.updateProfile(profile);
        int updatedRows_hasImg = profileRepository.hasImg(profile.getUser_id());
        if(updatedRows_hasImg >= 1) {
        	profileRepository.deleteImg(profile.getUser_id());
        }
        int updatedRows_profileImg = profileRepository.insertImg(profileImg);
        if (updatedRows_profile > 0) {
            return updatedRows_profile;
        } else {
            throw new DataAccessException("�봽濡쒗븘 �뾽�뜲�씠�듃�뿉 �떎�뙣�뻽�뒿�땲�떎.") {};
        }
    }
    
    @Override
    public boolean isNicknameAvailable(String nickname) throws DataAccessException {
    	String result = profileRepository.findByNickname(nickname);
    	if (result == null) {
            return true;
        }
    	return false;
    }
    
    @Override
    public boolean followUser(UserFollow userFollow) throws DataAccessException {
    	int result = profileRepository.insertUserFollow(userFollow);
    	if (result >= 1) {
            return true;
        }
    	return false;
    }
    
    @Override
	public boolean unfollowUser(UserFollow userFollow) throws DataAccessException {
		int result = profileRepository.deleteUserUnFollow(userFollow);
    	if (result >= 1) {
            return true;
        }
    	return false;
	}
    
    @Override
    public boolean checkUserFollow(UserFollow userFollow) throws DataAccessException {
    	int result = profileRepository.isFollowing(userFollow);
    	if (result >= 1) {
            return true;
        }
    	return false;
    }
    
    @Override
	public List<FollowerForm> Follower(int user_id)  {
		System.out.println("userFollower " + user_id);
		return profileRepository.Follower(user_id);
	}
	
	
	@Override
	public List<FollowingForm> Following(int user_id)  {
		System.out.println("userFollowing " + user_id);
		return profileRepository.Following(user_id);
	}
	
	@Override
	public ProfileImg getProfileImg(int user_id) {
		return profileRepository.selectProfileImg(user_id);
	}

}
