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
			return new ResponseEntity<>("회원가입 실패", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("회원가입 성공",HttpStatus.OK);
	}

	@RequestMapping(value = "/login" ,produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@Override
	public ResponseEntity<Integer> login(@RequestBody LoginForm loginform, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		member loginmember = memberService.login(loginform);
		
		if (loginmember == null) {
			return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
		}
		
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("loginMember", loginmember);
		
		return new ResponseEntity<>(loginmember.getUser_id(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/Manage_member" ,produces = "application/json; charset=utf8", method = RequestMethod.GET)
	@Override
	public ResponseEntity<List<member>> memberlist(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		 
		return new ResponseEntity<>(memberService.memberlist(),HttpStatus.OK);
	}

}
