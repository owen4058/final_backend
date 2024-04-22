package com.api.api.member.service;

import org.springframework.dao.DataAccessException;

import com.api.api.member.LoginForm;
import com.api.api.member.member;

public interface MemberService {
	public int addmember(member member)throws DataAccessException;
	public member login(LoginForm loginForm)throws DataAccessException;
	
}
