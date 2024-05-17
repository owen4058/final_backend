package com.api.api.admin.service;

import java.util.List;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.member.Member;

public interface AdminService {
	public List<ForumAdmin> adminforumlist();
	
	public List<ForumAdmin> adminforumdelete(int forum_id);
	
	public List<SectionAdmin> adminsectionlist();
	
	public List<SectionAdmin> adminsectiondelete(int forum_id);

	public int adminsectionedit(SectionAdmin sectionAdmin);
	
	public int adminforumedit(ForumAdmin forumAdmin);
	
	public ForumAdmin adminforumcheck(ForumAdmin forumAdmin);
	
	public List<Member> deletememberlist();
	
	public int roleuser(int user_id);
	
	public int recovermember(int user_id);

}
