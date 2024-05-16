package com.api.api.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.api.member.LoginForm;
import com.api.api.member.Member;

public interface MemberController {
	public ResponseEntity<String> save(@RequestBody Member member, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws Exception;
	public ResponseEntity<?> login(@RequestBody LoginForm loginform, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws Exception;
	public ResponseEntity<List<Member>> memberlist(int page, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception;
	public ResponseEntity<String> memberdleate(
			int user_id
			,HttpServletRequest httpServletRequest
			,HttpServletResponse httpServletResponse
			) throws Exception;
	public ResponseEntity<String> logout(
			HttpServletRequest request
			) throws Exception;
}
 