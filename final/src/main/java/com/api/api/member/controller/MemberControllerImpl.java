package com.api.api.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.api.member.LoginForm;
import com.api.api.member.member;
import com.api.api.member.service.MemberService;

@Controller("memberController")
public class MemberControllerImpl implements MemberController{
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/assign" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<String> save(@RequestBody member member, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		int vo = memberService.addmember(member);
		if (vo!=1) {
			return new ResponseEntity<>("ȸ������ ����", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("ȸ������ ����",HttpStatus.OK);
	}

	@RequestMapping(value = "/login" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<String> login(@RequestBody LoginForm loginform, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		HttpSession session = httpServletRequest.getSession();
		if (memberService.login(loginform) == null) {
			return new ResponseEntity<>("�α��� ����", HttpStatus.NOT_FOUND);
		}
		 
		
		return new ResponseEntity<>("�α��� ����",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/Manage_member" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<List<member>> memberlist(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		 
		return new ResponseEntity<>(memberService.memberlist(),HttpStatus.OK);
	}

}
