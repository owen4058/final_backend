package com.api.api.admin.controller;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;

public interface AdminController {
	
	
	
	public ResponseEntity<?> adminforumlist()
			throws Exception;

	public ResponseEntity<?> adminforumdelete(Integer forum_id) throws Exception;
	
	public ResponseEntity<?> adminsectioncreate(
			SectionAdmin sectionAdmin
			)
					throws Exception;
	
	public ResponseEntity<?> adminsectionlist()
			throws Exception;
	
	public ResponseEntity<?> adminsectiondelete(Integer section_id) throws Exception;

	public ResponseEntity<?> adminsectionedit(SectionAdmin sectionAdmin) throws Exception;

	public ResponseEntity<Integer> adminforumedit(
			ForumAdmin forumAdmin
			, MultipartFile file
			) throws Exception;
	
	public ResponseEntity<?> recovermember(
			 Integer section_id
			) throws Exception;
	
	public ResponseEntity<?> adminmember(
			@RequestParam Integer user_id
			) throws Exception;
	
	public ResponseEntity<?> deletememberlist() throws Exception;
}
