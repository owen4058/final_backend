package com.api.api.member.repository;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.api.api.member.LoginForm;
import com.api.api.member.member;

@Repository("memberRepository")
public class MemberRepositoryImpl implements MemberRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertmember(member member) throws DataAccessException {
		return sqlSession.insert("mapper.member.insertMember", member);
	}

	@Override
	public Optional<member> login(LoginForm loginForm) throws DataAccessException {
		System.out.println(loginForm.getPassword());
		return Optional.ofNullable(sqlSession.selectOne("mapper.member.loginById",loginForm));
	}
}
