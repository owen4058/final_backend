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
	int user_id; // ���̵�
	String user_email;  // ���̵�� ����ϴ� �̸���
	String password ; // ���
	String nickname; // ������
	String name; // ���� ����
	String pro_path; // ������ ���
	Date dateOfBirth;// ������ ������ ����������
	Date createdate; // ������¥
	
}
