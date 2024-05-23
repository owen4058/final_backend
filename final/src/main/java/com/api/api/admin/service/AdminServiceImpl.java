package com.api.api.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.admin.repository.AdminRepository;
import com.api.api.member.Member;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<ForumAdmin> adminforumlist() {
		return adminRepository.adminforumlist();
	}

	@Override
	public List<ForumAdmin> adminforumdelete(int forum_id) {
		adminRepository.adminforumsectiondelete(forum_id);
		adminRepository.adminforumdelete(forum_id);
		return adminRepository.adminforumlist();
	}
	
	@Override
	public List<SectionAdmin> adminsectionlist() {
		return adminRepository.adminsectionlist();
	}
	
	@Override
	public List<SectionAdmin> adminsectiondelete(int section_id) {
		adminRepository.adminsectiondelete(section_id);
		return adminRepository.adminsectionlist();
	}
	
	@Override
	public int adminsectionedit(SectionAdmin sectionAdmin) {
		return adminRepository.adminsectionedit(sectionAdmin);
	}

	@Override
	public int adminforumedit(ForumAdmin forumAdmin) {
		if (forumAdmin.getLogo_path() == null) {
			return adminRepository.adminforumeditnologo(forumAdmin);
		}
		return adminRepository.adminforumedit(forumAdmin);
	}

	@Override
	public ForumAdmin adminforumcheck(ForumAdmin forumAdmin) {
		return adminRepository.adminforumcheck(forumAdmin);
	}

	@Override
	public List<Member> deletememberlist() {
		return adminRepository.deletememberlist();
	}

	@Override
	public int roleuser(int user_id) {
		return adminRepository.roleuser(user_id);
	}
	
	@Override
	public int recovermember(int user_id) {
		return adminRepository.recovermember(user_id);
	}


}
