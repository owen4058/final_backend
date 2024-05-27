package com.api.api.profile;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("profileImg")
@Getter
@Setter
public class ProfileImg {
	int img_id;
	int user_id;
	String img_name;
	String img_path;
}
