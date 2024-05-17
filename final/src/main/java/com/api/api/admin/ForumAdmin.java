package com.api.api.admin;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("forum")
@Getter
@Setter

public class ForumAdmin {
	int forum_id;
	String forum_name;
	Date create_date;
	String logo_name;
	String logo_path;
	String forum_info;
	int create_user_id;
	
}
