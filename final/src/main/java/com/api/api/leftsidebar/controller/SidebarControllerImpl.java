package com.api.api.leftsidebar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.leftsidebar.FavoriteForum;
import com.api.api.leftsidebar.UserForumForm;
import com.api.api.leftsidebar.service.SidebarService;


@Controller("sidebarController")
public class SidebarControllerImpl implements SidebarController {
	
	@Autowired
	SidebarService sidebarService;

	@Override
	@RequestMapping(value = "/favorite_forum" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<FavoriteForum>> forumlist(
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(required = false)Integer user_id
			) throws Exception {
		
		if (user_id == null) {
			return new ResponseEntity<List<FavoriteForum>>(sidebarService.formlist_guest(page),HttpStatus.OK) ;
		}
		
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("page", page);
		data.put("user_id", user_id);
			
		return new ResponseEntity<List<FavoriteForum>>(sidebarService.forumlist(data),HttpStatus.OK) ;
	}
	
	@Override
	@RequestMapping(value = "/favorite_forum" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<List<FavoriteForum>> forumsave(
			@RequestBody UserForumForm userForumForm
			) throws Exception {
		return new ResponseEntity<List<FavoriteForum>>(sidebarService.forumsave(userForumForm), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/favorite_forum" ,produces = "application/json; charset=utf8", method = RequestMethod.DELETE)
	public ResponseEntity<List<FavoriteForum>> forumdelete(
			@RequestBody UserForumForm userForumForm
			) throws Exception {
		
		return new ResponseEntity<List<FavoriteForum>>(sidebarService.forumdelete(userForumForm), HttpStatus.OK);
	}

}
