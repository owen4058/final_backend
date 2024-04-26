package com.api.api.leftsidebar.service;

import java.util.List;
import java.util.Map;

import com.api.api.leftsidebar.FavoriteForum;
import com.api.api.leftsidebar.UserForumForm;

public interface SidebarService {
	public List<FavoriteForum> forumlist(Map<String, Object> data);
	
	public List<FavoriteForum> forumsave(UserForumForm userForumForm);
	
	public List<FavoriteForum> forumdelete(UserForumForm userForumForm);

}
