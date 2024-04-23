package com.api.api.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.member.LoginForm;
import com.api.api.member.member;

public interface MemberService {
	public int addmember(member member)throws DataAccessException;
	public member login(LoginForm loginForm)throws DataAccessException;
	public List<member> memberlist() throws DataAccessException;
	public List<member> memberdelate(int user_id) throws DataAccessException;
	
}
