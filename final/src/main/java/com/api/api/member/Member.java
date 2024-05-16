package com.api.api.member;

import java.util.Date;

import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.Setter;

@Component("member")
@Getter
@Setter

public class Member {
	int user_id; 
	String user_email;  
	String password ; 
	String nickname; 
	String name; 
	String pro_path;
	String role;
	Date dateOfBirth;
	Date createdate;
	int active_state;
	
	
}
