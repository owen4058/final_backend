package com.api.api.leftsidebar;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("favoriteForum")
@Getter
@Setter

public class FavoriteForum {
	int forum_id;
	String forum_name;
}
