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
import com.api.api.profile.ProfileImg;
import com.api.api.profile.UserFollow;

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
	public String findByNickname(String nickname) throws DataAccessException {
		try {
			String result = sqlSession.selectOne("mapper.profile.getNickname", nickname);
			System.out.println("result " + result);
			return result;
        } catch (Exception e) {
            throw new DataAccessException("게시글 목록 조회 중 오류가 발생했습니다.", e) {};
        }
	}
	
	@Override
	public int insertUserFollow(UserFollow userFollow) throws DataAccessException {
		try {
			System.out.println("insertIntoUserFollow " + userFollow.getUser_id());
			int result = sqlSession.insert("mapper.profile.insertIntoUserFollow", userFollow);
			return result;
        } catch (Exception e) {
            throw new DataAccessException("user follow repo error", e) {};
        }
	}
	@Override
	public int deleteUserUnFollow(UserFollow userFollow) throws DataAccessException {
		try {
			int result = sqlSession.delete("mapper.profile.deleteFromUserFollow", userFollow);
			System.out.println("deleteFromUserFollow " + userFollow.getUser_id());
			return result;
        } catch (Exception e) {
            throw new DataAccessException("user unfollow repo error", e) {};
        }
	}
	
	@Override
	public int insertImg(ProfileImg profileImg) throws DataAccessException {
		try {
			System.out.println("insertProfileImg " + profileImg.getUser_id());
			int result = sqlSession.insert("mapper.profile.insertProfileImg", profileImg);
			return result;
		} catch(Exception e) {
			throw new DataAccessException("insertProfileImg repo error", e) {};
		}
	}
	
	@Override
	public int deleteImg(int user_id) throws DataAccessException{
		System.out.println("delete Img repo");
		int result = sqlSession.delete("mapper.profile.deleteProfileImg", user_id);
		return result;
	}
	
	@Override
	public int isFollowing(UserFollow userFollow) throws DataAccessException{
		try {
			System.out.println("userFollow repo " + userFollow.getUser_id() + userFollow.getOpponent_id());
			int result = sqlSession.selectOne("mapper.profile.selectFromUserFollow", userFollow);
			return result;
		} catch(Exception e) {
			throw new DataAccessException("userFollow repo error", e) {};
		}
	}
	
	@Override
	public int hasImg(int user_id) throws DataAccessException {
		System.out.println("has image repo " + user_id);
		int result = sqlSession.selectOne("mapper.profile.hasImg", user_id);
		return result;
	}

	

}
