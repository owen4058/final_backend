package com.api.api.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.api.api.board.BoardForm;
import com.api.api.my.repository.MyRepository;

@Service("myService")
public class MyServiceImpl implements MyService{
	 @Autowired
	  private MyRepository myRepository;

	  @Override
	  public List<BoardForm> getMyBoardList(int user_id) throws DataAccessException {
	    return myRepository.selectMyBoardList(user_id); 
	  }

	  @Override 
	  public List<BoardForm> getCommentMyBoardList(int user_id) throws DataAccessException {
	    return myRepository.selectCommentMyBoardList(user_id);
	  }

	  @Override
	  public List<BoardForm> getLikedMyBoardList(int user_id) throws DataAccessException {  
	    return myRepository.selectLikedMyBoardList(user_id); 
	  }

	  @Override
	  public List<BoardForm> getSavedMyBoardList(int user_id) throws DataAccessException {
	    return myRepository.selectSavedMyBoardList(user_id);
	  }
}
