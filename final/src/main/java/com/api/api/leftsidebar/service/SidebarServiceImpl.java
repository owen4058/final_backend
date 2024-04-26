package com.api.api.leftsidebar.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.leftsidebar.FavoriteForum;
import com.api.api.leftsidebar.repository.SidebarRepository;


@Service("sidebarService")
public class SidebarServiceImpl implements SidebarService{
	
	@Autowired
	SidebarRepository sidebarRepository;
	@Override
	public List<FavoriteForum> forumlist(Map<String, Object> data) {
		return sidebarRepository.formlist(data);
	}

}
