package com.api.api.forum.service;

import java.util.List;
import java.util.Map;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.forum.ForumForm;


public interface ForumService {
	public List<ForumForm> forumselect(Map<String, Object> data);

	public List<ForumForm> forumlist();
	
	public List<SectionAdmin> sectioncreate(SectionAdmin sectionAdmin);
	
	public List<ForumAdmin> forumcreate(ForumAdmin forumAdmin, List<SectionAdmin>  section);
	
	public ForumForm forumcheck(int forum_id);

}
