package com.api.api.member;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Component("member")
@Getter
@Setter

public class member {
	int user_id; // 아이디
	String user_email;  // 아이디로 사용하는 이메일
	String password ; // 비번
	String nickname; // ㅈㄱㄴ
	String name; // 유저 본명
	String pro_path; // 프로필 경로
	Date dateOfBirth;// 프로필 사진은 마이페이지
	Date createdate; // 생성날짜
	
}
