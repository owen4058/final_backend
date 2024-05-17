package com.api.api.forum.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.forum.ForumForm;
import com.api.api.forum.service.ForumService;

@Controller("forumController")
public class ForumControllerImpl implements ForumController{
	
	@Autowired
	private ForumService forumService;
	
	
	
	@Override
	@RequestMapping(value = "/forum" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<List<ForumAdmin>> forumcreate(
			@RequestPart(name = "forum") ForumAdmin forum
			,@RequestPart(name = "file", required = false) MultipartFile file
			) throws Exception {
		forum.setLogo_path("null");
		String filepath = "c:\\imgs\\admin\\forum_logo"+File.separator+forum.getForum_name();
		
		try {
			if (!file.isEmpty()) {
				String filename = file.getOriginalFilename();
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filepath, filename));
				forum.setLogo_path(filepath+"/"+ filename);
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<List<ForumAdmin>>(forumService.forumcreate(forum), HttpStatus.OK);
		}
		
		return new ResponseEntity<List<ForumAdmin>>(forumService.forumcreate(forum), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/section" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<?> sectioncreate(
			@RequestBody SectionAdmin sectionAdmin
			) throws Exception {
		return new ResponseEntity<>(forumService.sectioncreate(sectionAdmin),HttpStatus.OK);
	}
	
	
	
	@Override
	@RequestMapping(value = "/forum_information" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<ForumForm>> forumselect(
			@RequestParam Integer forum_id,
			@RequestParam Integer user_id,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("forum_id", forum_id);
		data.put("user_id", user_id);

		List<ForumForm> vo = forumService.forumselect(data);
		
		return new ResponseEntity<List<ForumForm>>(vo, HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/forum" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<ForumForm>> forumlist() throws Exception {

		List<ForumForm> vo = forumService.forumlist();
		
		return new ResponseEntity<List<ForumForm>>(vo, HttpStatus.OK);
	}


}
