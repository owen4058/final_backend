package com.api.api.member;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("loginForm")
@Getter
@Setter

public class LoginForm {
	String user_email; 
	String password ;
}
