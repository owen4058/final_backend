package com.api.api.leftsidebar;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("UserForumForm")
@Getter
@Setter
public class UserForumForm {
	int user_id;
	int forum_id;
}
