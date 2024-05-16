package com.api.api.leftsidebar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.leftsidebar.FavoriteForum;
import com.api.api.leftsidebar.UserForumForm;
import com.api.api.leftsidebar.repository.SidebarRepository;


@Service("sidebarService")
public class SidebarServiceImpl implements SidebarService{
	
	@Autowired
	SidebarRepository sidebarRepository;
	
	@Override
	public List<FavoriteForum> forumlist(Map<String, Object> data) {
		return sidebarRepository.formlist(data);
	}
	
	@Override
	public List<FavoriteForum> forumsave(UserForumForm userForumForm) {
		sidebarRepository.forumsave(userForumForm);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_id", userForumForm.getUser_id());
		data.put("page", 1);
		
		return sidebarRepository.formlist(data);
	}

	@Override
	public List<FavoriteForum> forumdelete(UserForumForm userForumForm) {
		sidebarRepository.forumdelete(userForumForm);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_id", userForumForm.getUser_id());
		data.put("page", 1);
		
		return sidebarRepository.formlist(data);
	}
	
	@Override
	public List<FavoriteForum> formlist_guest(int page) {
		return sidebarRepository.formlist_guest(page);
	}

}
