package com.api.api.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.api.api.member.LoginForm;
import com.api.api.member.member;
import com.api.api.member.repository.MemberRepository;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public int addmember(member member) throws DataAccessException {
		return memberRepository.insertmember(member);
	}

	@Override
	public member login(LoginForm loginForm) throws DataAccessException {
		return memberRepository.login(loginForm).filter(m->m.getPassword().equals(loginForm.getPassword())).orElse(null);
	}
	@Override
	public List<member> memberlist() throws DataAccessException {
		return memberRepository.memberlist();
	}
	@Override
	public List<member> memberdelate(int user_id) throws DataAccessException {
		return memberRepository.memberdelate(user_id);
	}

}
