package com.api.api.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
