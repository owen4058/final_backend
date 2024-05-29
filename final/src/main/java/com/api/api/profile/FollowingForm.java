package com.api.api.profile;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("followingForm")
@Getter
@Setter
@NoArgsConstructor
public class FollowingForm {
	
	int following_user_id;
    String following_user_nickName;
    int following_state;

}
