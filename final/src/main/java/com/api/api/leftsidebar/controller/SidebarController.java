package com.api.api.leftsidebar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.api.api.leftsidebar.FavoriteForum;
import com.api.api.leftsidebar.UserForumForm;

public interface SidebarController {
	public ResponseEntity<List<FavoriteForum>> forumlist(
			Integer page
			, Integer user_id

			) throws Exception;

	public ResponseEntity<List<FavoriteForum>> forumsave(
			UserForumForm userForumForm
			) throws Exception;
	
	public ResponseEntity<List<FavoriteForum>> forumdelete(
			UserForumForm userForumForm
			) throws Exception;

}
