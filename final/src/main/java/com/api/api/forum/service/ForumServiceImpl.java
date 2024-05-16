package com.api.api.forum.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.forum.ForumForm;
import com.api.api.forum.repository.ForumRepository;


@Service("forumService")
public class ForumServiceImpl implements ForumService{
	
	@Autowired
	private ForumRepository forumRepository;

	@Override
	public List<ForumForm> forumselect(Map<String, Object> data) {
		return forumRepository.forumselect(data);
	}
	
	@Override
	public List<ForumForm> forumlist() {
		return forumRepository.forumlist();
	}

}
