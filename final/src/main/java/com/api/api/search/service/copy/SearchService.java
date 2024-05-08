package com.api.api.search.service.copy;

import java.util.List;
import java.util.Map;

import com.api.api.board.BoardForm;
import com.api.api.forum.ForumForm;


public interface SearchService {
	public List<ForumForm> searchforum(Map<String, Object> searchinfo);
	
	public List<BoardForm> searchboardtitle(Map<String, Object> searchinfo);

	public List<BoardForm> searchboardcontent(Map<String, Object> searchinfo);

}
