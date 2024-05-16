package com.api.api.forum.repository;

import java.util.List;
import java.util.Map;

import com.api.api.forum.ForumForm;


public interface ForumRepository {
	public List<ForumForm> forumselect(Map<String, Object> data);
	
	public List<ForumForm> forumlist();

}
