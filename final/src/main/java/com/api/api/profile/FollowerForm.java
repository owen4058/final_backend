package com.api.api.profile;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("followerForm")
@Getter
@Setter
@NoArgsConstructor
public class FollowerForm {
	
	int follower_user_id;
    String follower_user_nickName;
    int following_state;

}
