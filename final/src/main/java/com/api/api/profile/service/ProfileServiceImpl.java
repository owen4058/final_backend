package com.api.api.profile.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.api.api.board.BoardForm;
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
            // 업데이트된 행이 있으면, 업데이트된 프로필 정보를 반환
            return profileRepository.selectProfile(user_id);
        } else {
            // 업데이트된 행이 없으면, 적절한 예외를 발생시키거나 다른 처리를 함
            throw new DataAccessException("프로필 업데이트에 실패했습니다.") {};
        }
    }

//    @Override
//    public List<BoardForm> getMyBoardList(int user_id) throws DataAccessException {
////    	return boardRepository.boardlist(null);
//        return profileRepository.selectMyBoardList(user_id);
//    }
	

}
