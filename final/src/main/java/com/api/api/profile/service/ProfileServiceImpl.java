package com.api.api.profile.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.api.api.board.repository.BoardRepository;
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
    
    public boolean followUser(UserFollow userFollow) throws DataAccessException {
    	int result = profileRepository.insertUserFollow(userFollow);
    	if (result >= 1) {
            return true;
        }
    	return false;
    }
	public boolean unfollowUser(UserFollow userFollow) throws DataAccessException {
		int result = profileRepository.deleteUserUnFollow(userFollow);
    	if (result >= 1) {
            return true;
        }
    	return false;
	}

}
