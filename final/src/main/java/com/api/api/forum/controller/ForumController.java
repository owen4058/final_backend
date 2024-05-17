package com.api.api.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.forum.ForumForm;

public interface ForumController {
	
	public ResponseEntity<?> forumcreate(
			ForumAdmin forumAdmin
			, MultipartFile file
			)
			throws Exception;
	
	public ResponseEntity<?> sectioncreate(
			SectionAdmin sectionAdmin
			)
					throws Exception;
	
	public ResponseEntity<List<ForumForm>> forumselect(Integer forum_id,Integer user_id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;

	public ResponseEntity<List<ForumForm>> forumlist() throws Exception;
}
