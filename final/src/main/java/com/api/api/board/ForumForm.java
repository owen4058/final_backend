package com.api.api.board;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component("forumForm")
@Getter
@Setter

public class ForumForm {
	int forum_id;
	String logo_path;
	String forum_name;
	List<SectionForm> section;
	List<BoardForm> board;
	
}
