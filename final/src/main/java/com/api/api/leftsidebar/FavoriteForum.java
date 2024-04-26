package com.api.api.leftsidebar;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.api.forum.SectionForm;

import lombok.Getter;
import lombok.Setter;

@Component("favoriteForum")
@Getter
@Setter

public class FavoriteForum {
	int forum_id;
	String forum_name;
	List<SectionForm> sectionform;
}
