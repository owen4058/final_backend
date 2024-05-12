package com.api.api.profile.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.api.api.board.repository.BoardRepository;
import com.api.api.profile.Profile;
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
    public Profile updateProfile(int user_id, Profile profile) throws DataAccessException {
        int updatedRows = profileRepository.updateProfile(profile);
        if (updatedRows > 0) {
            return profileRepository.selectProfile(user_id);
        } else {
            throw new DataAccessException("�봽濡쒗븘 �뾽�뜲�씠�듃�뿉 �떎�뙣�뻽�뒿�땲�떎.") {};
        }
    }
    
    @Override
    public boolean isNicknameAvailable(String nickname) throws DataAccessException {
    	return profileRepository.findByNickname(nickname);
    }

}
