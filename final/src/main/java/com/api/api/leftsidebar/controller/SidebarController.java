package com.api.api.leftsidebar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.api.api.leftsidebar.FavoriteForum;

public interface SidebarController {
	public ResponseEntity<List<FavoriteForum>> forumlist(Integer page, Integer user_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
