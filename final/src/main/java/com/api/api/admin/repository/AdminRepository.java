package com.api.api.admin.repository;

import java.util.List;

import com.api.api.admin.ForumAdmin;

public interface AdminRepository {
	public List<ForumAdmin> adminforumlist();
	public int adminforumcreate(ForumAdmin forumAdmin);
	public int adminforumdelete(int forum_id);



}
