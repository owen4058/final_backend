package com.api.api.member.repository;

import org.springframework.dao.DataAccessException;

import com.api.api.member.member;

public interface MemberRepository {
	public int insertmember(member member) throws DataAccessException;
}
