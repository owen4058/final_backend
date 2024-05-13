package com.api.api.profile.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.api.api.board.BoardForm;
import com.api.api.profile.Profile;

@Repository("profileRepository")
public class ProfileRepositoryImpl implements ProfileRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Profile selectProfile(int user_id) throws DataAccessException {
		try {
            Map<String, Object> params = new HashMap<>();
            params.put("user_id", user_id);
            return sqlSession.selectOne("mapper.profile.getProfile", params);
        } catch (Exception e) {
            throw new DataAccessException("프로필 정보 조회 중 오류가 발생했습니다.", e) {};
        }
	}
	
	@Override
	public int updateProfile(Profile profile) throws DataAccessException {
        try {
            int updatedRows = sqlSession.update("mapper.profile.updateProfile", profile);
            return updatedRows;

        } catch (Exception e) {
            throw new DataAccessException("프로필 정보 조회 중 오류가 발생했습니다.", e) {};
        }
    }
	
	@Override
	public List<BoardForm> selectMyBoardList(int user_id) throws DataAccessException {
        try {
            return sqlSession.selectList("mapper.profile.myBoardList", user_id);
        } catch (Exception e) {
            throw new DataAccessException("게시글 목록 조회 중 오류가 발생했습니다.", e) {};
        }
    }
	
	@Override
	public int findByNickname(String nickname) throws DataAccessException {
		return sqlSession.selectOne("mapper.profile.getNickname", nickname);
	}
	

}
