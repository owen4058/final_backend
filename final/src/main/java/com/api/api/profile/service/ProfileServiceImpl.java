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
            // �뾽�뜲�씠�듃�맂 �뻾�씠 �엳�쑝硫�, �뾽�뜲�씠�듃�맂 �봽濡쒗븘 �젙蹂대�� 諛섑솚
            return profileRepository.selectProfile(user_id);
        } else {
            // �뾽�뜲�씠�듃�맂 �뻾�씠 �뾾�쑝硫�, �쟻�젅�븳 �삁�쇅瑜� 諛쒖깮�떆�궎嫄곕굹 �떎瑜� 泥섎━瑜� �븿
            throw new DataAccessException("�봽濡쒗븘 �뾽�뜲�씠�듃�뿉 �떎�뙣�뻽�뒿�땲�떎.") {};
        }
    }

//    @Override
//    public List<BoardForm> getMyBoardList(int user_id) throws DataAccessException {
////    	return boardRepository.boardlist(null);
//        return profileRepository.selectMyBoardList(user_id);
//    }
	

}
