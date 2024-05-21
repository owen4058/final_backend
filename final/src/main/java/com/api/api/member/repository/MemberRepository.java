package com.api.api.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;

import com.api.api.member.LoginForm;
import com.api.api.member.Member;

public interface MemberRepository {
	public int insertmember(Member member) throws DataAccessException;
	public Optional<Member> login(LoginForm loginForm) throws DataAccessException;
	public List<Member> memberlist(int page) throws DataAccessException;
	public int memberdelate(int user_id) throws DataAccessException;	
	public String findByEmail(String user_email) throws DataAccessException;
}
