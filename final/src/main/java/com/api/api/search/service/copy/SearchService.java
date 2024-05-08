package com.api.api.search.service.copy;

import java.util.List;
import java.util.Map;

import com.api.api.forum.ForumForm;


public interface SearchService {
	public List<ForumForm> searchforum(Map<String, Object> searchinfo);
	
	public List<ForumForm> searchboardtitle(Map<String, Object> searchinfo);


}
