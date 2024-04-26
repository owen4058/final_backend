package com.api.api.forum.service;

import java.util.List;
import java.util.Map;

import com.api.api.forum.ForumForm;


public interface ForumService {
	public List<ForumForm> forumlist(Map<String, Object> data);


}
