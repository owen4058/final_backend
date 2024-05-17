package com.api.api.forum.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.admin.repository.AdminRepository;
import com.api.api.forum.ForumForm;
import com.api.api.forum.repository.ForumRepository;


@Service("forumService")
public class ForumServiceImpl implements ForumService{
	
	@Autowired
	private ForumRepository forumRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<ForumForm> forumselect(Map<String, Object> data) {
		return forumRepository.forumselect(data);
	}
	
	@Override
	public List<ForumAdmin> forumcreate(ForumAdmin forumAdmin) {
		forumRepository.forumcreate(forumAdmin);
		return adminRepository.adminforumlist();
	}
	
	@Override
	public List<SectionAdmin> sectioncreate(SectionAdmin sectionAdmin) {
		forumRepository.sectioncreate(sectionAdmin);
		return adminRepository.adminsectionlist();
	}
	
	@Override
	public List<ForumForm> forumlist() {
		return forumRepository.forumlist();
	}

}
