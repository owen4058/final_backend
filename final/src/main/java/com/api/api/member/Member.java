package com.api.api.member;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Component("member")
@Getter
@Setter

public class Member {
	int user_id; // 유저 id
	String user_email;  // 占쏙옙占싱듸옙占� 占쏙옙占쏙옙求占� 占싱몌옙占쏙옙
	String password ; // 占쏙옙占�
	String nickname; // 占쏙옙占쏙옙占쏙옙
	String name; // 占쏙옙占쏙옙 占쏙옙占쏙옙
	String pro_path; // 占쏙옙占쏙옙占쏙옙 占쏙옙占�
	Date dateOfBirth;// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
	Date createdate; // 占쏙옙占쏙옙占쏙옙짜
	
}
