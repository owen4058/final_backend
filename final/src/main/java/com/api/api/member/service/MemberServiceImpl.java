package com.api.api.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

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

}
