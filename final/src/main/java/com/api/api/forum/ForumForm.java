package com.api.api.forum;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Component("forumForm")
@Getter
@Setter
@NoArgsConstructor

public class ForumForm {
	int forum_id;
	int people;
	int forum_following_state;
	String logo_path;
	String forum_name;
	List<SectionForm> section;
	
}
