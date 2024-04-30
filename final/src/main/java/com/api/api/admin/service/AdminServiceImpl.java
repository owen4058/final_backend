package com.api.api.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.repository.AdminRepository;
import com.api.api.board.BoardCreateForm;
import com.api.api.board.BoardForm;
import com.api.api.board.BoardImg;
import com.api.api.board.Hashtag;
import com.api.api.board.repository.BoardRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<ForumAdmin> adminforumlist() {
		return adminRepository.adminforumlist();
	}

	@Override
	public List<ForumAdmin> adminforumcreate(ForumAdmin forumAdmin) {
		adminRepository.adminforumcreate(forumAdmin);
		return adminRepository.adminforumlist();
	}


}
