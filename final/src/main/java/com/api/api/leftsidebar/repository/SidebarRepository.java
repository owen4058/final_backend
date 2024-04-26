package com.api.api.leftsidebar.repository;

import java.util.List;
import java.util.Map;

import com.api.api.leftsidebar.FavoriteForum;
import com.api.api.leftsidebar.UserForumForm;

public interface SidebarRepository {
	public List<FavoriteForum> formlist(Map<String, Object> data);

	public int forumsave(UserForumForm userForumForm);
	
	public int forumdelete(UserForumForm userForumForm);
	

}
