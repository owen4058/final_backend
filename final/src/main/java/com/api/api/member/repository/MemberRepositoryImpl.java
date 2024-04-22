package com.api.api.member.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.api.api.member.member;

@Repository("memberRepository")
public class MemberRepositoryImpl implements MemberRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertmember(member member) throws DataAccessException {
		System.out.println(member.getNickname());
		return sqlSession.insert("mapper.member.insertMember", member);
	}

}
