package com.api.api.admin.repository;

import java.util.List;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;

public interface AdminRepository {
	public List<ForumAdmin> adminforumlist();
	public int adminforumcreate(ForumAdmin forumAdmin);
	public int adminforumdelete(int forum_id);
	
	public List<SectionAdmin> adminsectionlist();
	public int adminsectioncreate(SectionAdmin sectionAdmin);
	public int adminsectiondelete(int section_id);



}
