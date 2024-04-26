package com.api.api.forum.repository;

import java.util.List;
import java.util.Map;

import com.api.api.forum.ForumForm;


public interface ForumRepository {
	public List<ForumForm> forumlist(Map<String, Object> data);

}
