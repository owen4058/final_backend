package com.api.api.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.forum.ForumForm;
import com.api.api.search.service.copy.SearchService;

@Controller("searchController")
public class SearchControllerImpl implements SearchController{
	
	@Autowired
	private SearchService searchService;
	
	@Override
	@RequestMapping(value = "/search_forum" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<ForumForm>> searchforum(
			@RequestParam String search_forum
			,@RequestParam Integer user_id
			,@RequestParam(defaultValue = "1") Integer page
			) throws Exception {
		
		Map<String, Object> searchinfo = new HashMap<>();
		searchinfo.put("search", search_forum.toLowerCase());
		searchinfo.put("user_id", user_id);
		searchinfo.put("page", page);
		
		return new ResponseEntity<List<ForumForm>>(searchService.searchforum(searchinfo), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/search_title" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<ForumForm>> searchboardtitle(
			@RequestParam String search_title
			,@RequestParam Integer user_id
			,@RequestParam(defaultValue = "1") Integer page
			) throws Exception {
		Map<String, Object> searchinfo = new HashMap<>();
		searchinfo.put("search", search_title.toLowerCase());
		searchinfo.put("user_id", user_id);
		searchinfo.put("page", page);
		
		return new ResponseEntity<List<ForumForm>>(searchService.searchboardtitle(searchinfo), HttpStatus.OK);
	}


}
