package com.api.api.forum.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
			,@RequestPart(name = "section") List<SectionAdmin>  section
			,@RequestPart(name = "file", required = false) MultipartFile file,
			HttpServletRequest request
			) throws Exception {
		forum.setLogo_path("null");
		System.out.println(request.getSession().getServletContext().getRealPath("imgs\\admin\\forum_logo"+File.separator+forum.getForum_name()));
		String filepath = request.getSession().getServletContext().getRealPath("imgs\\admin\\forum_logo"+File.separator+forum.getForum_name()) ;
		
		try {
			if (!file.isEmpty()) {
				String filename = file.getOriginalFilename();
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filepath, filename));
				forum.setLogo_path(filepath+"/"+ filename);
				forum.setLogo_name(filename);
			}
		} catch (NullPointerException e) {
			return new ResponseEntity<List<ForumAdmin>>(forumService.forumcreate(forum, section), HttpStatus.OK);
		}
		
		return new ResponseEntity<List<ForumAdmin>>(forumService.forumcreate(forum, section), HttpStatus.OK);
	}
	
	@GetMapping("/forum/display")
	public ResponseEntity<byte[]> getImage(@RequestParam Integer forum_id, HttpServletRequest request) {
		
		System.out.println("getImage()........." + forum_id);
		URL r = this.getClass().getResource("");
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("forum_id", forum_id);
		data.put("user_id", 0);
		ForumForm forum_name = forumService.forumselect(data).get(0);
		
		
		
		File file = new File(request.getSession().getServletContext().getRealPath("imgs\\admin\\forum_logo"+File.separator+forum_name.getForum_name()+File.separator+ forum_name.getLogo_name()));
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
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
			@RequestParam(defaultValue = "0") Integer user_id,
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
