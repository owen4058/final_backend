package com.api.api.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.api.api.forum.ForumForm;

public interface ForumController {
	public ResponseEntity<List<ForumForm>> forumselect(Integer forum_id,Integer user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;

	public ResponseEntity<List<ForumForm>> forumlist() throws Exception;
}
