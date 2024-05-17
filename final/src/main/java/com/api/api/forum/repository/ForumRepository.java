package com.api.api.forum.repository;

import java.util.List;
import java.util.Map;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.forum.ForumForm;


public interface ForumRepository {
	public List<ForumForm> forumselect(Map<String, Object> data);
	
	public int forumcreate(ForumAdmin forumAdmin);
	
	public int sectioncreate(SectionAdmin sectionAdmin);
	
	public int sectioncreate(List<SectionAdmin> section);
	
	public List<ForumForm> forumlist();

}
