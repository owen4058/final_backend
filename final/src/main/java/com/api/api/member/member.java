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
	String user_email; 
	String password ;
	String nickname;
	String name;
	Date dateOfBirth;// ������ ������ ����������
}
