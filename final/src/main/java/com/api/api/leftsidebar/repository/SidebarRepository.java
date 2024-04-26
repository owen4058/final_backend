package com.api.api.leftsidebar.repository;

import java.util.List;
import java.util.Map;

import com.api.api.leftsidebar.FavoriteForum;

public interface SidebarRepository {
	public List<FavoriteForum> formlist(Map<String, Object> data);
	

}
