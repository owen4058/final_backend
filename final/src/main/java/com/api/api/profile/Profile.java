package com.api.api.profile;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("profile")
@Getter
@Setter

public class Profile {
	int user_id;
	String nickname;
	String user_email;
	String pro_path; // profile image
	int following_count;
	int follower_count;
	int board_count;
	int comment_count;
	int likes_count;
}
