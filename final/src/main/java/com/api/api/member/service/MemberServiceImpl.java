package com.api.api.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.api.api.member.LoginForm;
import com.api.api.member.Member;
import com.api.api.member.repository.MemberRepository;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public int addmember(Member member) throws DataAccessException {
		return memberRepository.insertmember(member);
	}

	@Override
	public Member login(LoginForm loginForm) throws DataAccessException {
		return memberRepository.login(loginForm).filter(m->m.getPassword().equals(loginForm.getLogin_password())).orElse(null);
	}
	@Override
	public List<Member> memberlist() throws DataAccessException {
		return memberRepository.memberlist();
	}
	@Override
	public List<Member> memberdelate(int user_id) throws DataAccessException {
		return memberRepository.memberdelate(user_id);
	}

}
