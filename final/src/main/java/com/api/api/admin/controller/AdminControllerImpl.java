package com.api.api.admin.controller;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.api.api.admin.service.AdminService;
import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;
import com.api.api.board.service.BoardService;
import com.api.api.forum.service.ForumService;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController{
	
	@Autowired
	private AdminService adminservice;
	
	@Override
	@RequestMapping(value = "/Manage_Forum" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<List<ForumAdmin>> adminforumcreate(
			@RequestPart(name = "forum") ForumAdmin forum
			,@RequestPart(required = false ,name = "file") MultipartFile file
			) throws Exception {
		String filepath = "c:\\imgs\\admin\\forum_logo"+File.separator+forum.getForum_name();
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filepath, filename));
			forum.setLogo_path(filepath+"/"+ filename);
		}
		
		return new ResponseEntity<List<ForumAdmin>>(adminservice.adminforumcreate(forum), HttpStatus.OK);
	}
	

}
