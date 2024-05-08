package com.api.api.search.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.api.api.board.BoardForm;
import com.api.api.forum.ForumForm;

public interface SearchController {
	public ResponseEntity<List<ForumForm>> searchforum(
			String search
			,Integer user_id
			,Integer page
			)
			throws Exception;
	
	public ResponseEntity<List<BoardForm>> searchboardtitle(
			String search
			,Integer user_id
			,Integer page
			)
					throws Exception;

	public ResponseEntity<List<BoardForm>> searchboardcontent(String search_content, Integer user_id, Integer page)
			throws Exception;

}
