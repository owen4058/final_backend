package com.api.api.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.member.LoginForm;
import com.api.api.member.Member;

public interface MemberService {
	public int addmember(Member member)throws DataAccessException;
	public Member login(LoginForm loginForm)throws DataAccessException;
	public List<Member> memberlist(int page) throws DataAccessException;
	public int memberdelate(int user_id) throws DataAccessException;
	
}
