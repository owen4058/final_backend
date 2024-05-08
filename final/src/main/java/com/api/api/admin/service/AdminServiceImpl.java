package com.api.api.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.admin.repository.AdminRepository;

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

	@Override
	public List<ForumAdmin> adminforumdelete(int forum_id) {
		adminRepository.adminforumdelete(forum_id);
		return adminRepository.adminforumlist();
	}
	
	@Override
	public List<SectionAdmin> adminsectionlist() {
		return adminRepository.adminsectionlist();
	}
	
	@Override
	public List<SectionAdmin> adminsectioncreate(SectionAdmin sectionAdmin) {
		adminRepository.adminsectioncreate(sectionAdmin);
		return adminRepository.adminsectionlist();
	}
	
	@Override
	public List<SectionAdmin> adminsectiondelete(int section_id) {
		adminRepository.adminsectiondelete(section_id);
		return adminRepository.adminsectionlist();
	}


}
