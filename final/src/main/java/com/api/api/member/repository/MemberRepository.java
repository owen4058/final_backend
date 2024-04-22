package com.api.api.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;

import com.api.api.member.LoginForm;
import com.api.api.member.member;

public interface MemberRepository {
	public int insertmember(member member) throws DataAccessException;
	public Optional<member> login(LoginForm loginForm) throws DataAccessException;
	public List<member> memberlist() throws DataAccessException;	
}
