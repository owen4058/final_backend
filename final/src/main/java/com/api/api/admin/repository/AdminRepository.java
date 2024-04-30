package com.api.api.admin.repository;

import java.util.List;
import java.util.Map;

import com.api.api.admin.ForumAdmin;
import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;

public interface AdminRepository {
	public List<ForumAdmin> adminforumlist();
	public int adminforumcreate(ForumAdmin forumAdmin);



}
