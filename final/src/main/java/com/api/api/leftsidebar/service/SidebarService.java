package com.api.api.leftsidebar.service;

import java.util.List;
import java.util.Map;

import com.api.api.leftsidebar.FavoriteForum;

public interface SidebarService {
	public List<FavoriteForum> forumlist(Map<String, Object> data);

}
