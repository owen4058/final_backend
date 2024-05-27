package com.api.api.profile;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("UserFollow")
@Getter
@Setter
@NoArgsConstructor
public class UserFollow {
	int user_id;
    int opponent_id;

}
