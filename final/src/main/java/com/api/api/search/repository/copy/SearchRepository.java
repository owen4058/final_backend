package com.api.api.search.repository.copy;

import java.util.List;
import java.util.Map;

import com.api.api.board.BoardForm;
import com.api.api.forum.ForumForm;


public interface SearchRepository {
	
	public List<ForumForm> searchforum(Map<String, Object> searchinfo);
	
	public List<BoardForm> searchboardtitle(Map<String, Object> searchinfo);

	public List<BoardForm> searchboardcontent(Map<String, Object> searchinfo);

}
