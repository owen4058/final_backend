package com.api.api.member;


import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("loginForm")
@Getter
@Setter

public class LoginForm {
	String user_email; 
	String login_password ;
}
