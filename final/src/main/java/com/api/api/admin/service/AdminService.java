package com.api.api.admin.service;

import java.util.List;

import com.api.api.admin.ForumAdmin;

public interface AdminService {
	public List<ForumAdmin> adminforumlist();
	
	public List<ForumAdmin> adminforumcreate(ForumAdmin forumAdmin);
	
	public List<ForumAdmin> adminforumdelete(int forum_id);

}
