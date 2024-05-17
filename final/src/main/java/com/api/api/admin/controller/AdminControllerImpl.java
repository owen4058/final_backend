package com.api.api.admin.controller;

import java.io.File;
import java.util.List;


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
import com.api.api.admin.service.AdminService;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController{
	
	@Autowired
	private AdminService adminservice;
	
	

	@Override
	@RequestMapping(value = "/Manage_Forum" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<List<ForumAdmin>> adminforumlist() throws Exception {
		return new ResponseEntity<List<ForumAdmin>>(adminservice.adminforumlist(), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/Manage_Forum" ,produces = "application/json; charset=utf8", method = RequestMethod.DELETE)
	public ResponseEntity<List<ForumAdmin>> adminforumdelete(
			@RequestParam Integer forum_id
			) throws Exception {
		return new ResponseEntity<List<ForumAdmin>>(adminservice.adminforumdelete(forum_id), HttpStatus.OK);
	}



	@Override
	@RequestMapping(value = "/Manage_section" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<?> adminsectionlist() throws Exception {
		return  new ResponseEntity<>(adminservice.adminsectionlist(),HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/Manage_section" ,produces = "application/json; charset=utf8", method = RequestMethod.DELETE)
	public ResponseEntity<?> adminsectiondelete(
			@RequestParam Integer section_id
			) throws Exception {
		return  new ResponseEntity<>(adminservice.adminsectiondelete(section_id),HttpStatus.OK);
	}
	

	@Override
	@RequestMapping(value = "/Manage_section_edit" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<Integer> adminsectionedit(
			@RequestBody SectionAdmin sectionAdmin
			) throws Exception {
		return  new ResponseEntity<Integer>(adminservice.adminsectionedit(sectionAdmin),HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/Manage_Forum_edit" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<Integer> adminforumedit(
			@RequestPart(name = "forum") ForumAdmin forum
			,@RequestPart(required = false ,name = "file") MultipartFile file
			) throws Exception {
		
		String filepath = "c:\\imgs\\admin\\forum_logo"+File.separator+forum.getForum_name();
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filepath, filename));
			forum.setLogo_path(filepath+"/"+ filename);
		}
		
		System.out.println("이상 무");
		ForumAdmin vo = adminservice.adminforumcheck(forum);
		String logo = vo.getLogo_path();
		System.out.println("ddddd " + logo);
		if (forum.getLogo_path() != null) {
			if (logo != forum.getLogo_path()) {
				//현재 게시판에 존재하는 파일객체를 만듬
				File file2 = new File(logo);
						
				if(file2.exists()) { // 파일이 존재하면
					file2.delete(); // 파일 삭제	
				}
			}
		}
		
		
		return  new ResponseEntity<Integer>(adminservice.adminforumedit(forum), HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/Recover_member" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<?> recovermember(
			@RequestParam Integer user_id
			) throws Exception {
		return new ResponseEntity<>(adminservice.recovermember(user_id), HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(value = "/user_admin" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<?> adminmember(
			@RequestParam Integer user_id
			) throws Exception {
		
		System.out.println();
		
		if (adminservice.roleuser(user_id) == 1) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("bad", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@Override
	@RequestMapping(value = "/deleted_member" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	public ResponseEntity<?> deletememberlist() throws Exception {
		return new ResponseEntity<>(adminservice.deletememberlist(),HttpStatus.OK);
	}

}
