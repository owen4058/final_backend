package com.api.api.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.api.api.member.member;

public interface MemberController {
	public ResponseEntity<String> save(@RequestBody member member, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws Exception;
}
 