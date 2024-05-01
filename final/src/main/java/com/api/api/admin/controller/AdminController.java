package com.api.api.admin.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.admin.ForumAdmin;

public interface AdminController {
	
	public ResponseEntity<List<ForumAdmin>> adminforumcreate(
			ForumAdmin forumAdmin
			, MultipartFile file
			)
			throws Exception;
	
	public ResponseEntity<List<ForumAdmin>> adminforumlist()
			throws Exception;

	public ResponseEntity<List<ForumAdmin>> adminforumdelete(Integer forum_id) throws Exception;

}
