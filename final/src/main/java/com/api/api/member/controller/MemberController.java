package com.api.api.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.api.member.LoginForm;
import com.api.api.member.member;

public interface MemberController {
	public ResponseEntity<String> save(@RequestBody member member, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws Exception;
	public ResponseEntity<Integer> login(@RequestBody LoginForm loginform, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws Exception;
	public ResponseEntity<List<member>> memberlist(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;
}
 