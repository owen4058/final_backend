package com.api.api.admin.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;

@Repository("adminRepository")
public class AdminRepositoryImpl implements AdminRepository{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ForumAdmin> adminforumlist() {
		return sqlSession.selectList("mapper.admin.form_admin_list");
	}
	@Override
	public int adminforumcreate(ForumAdmin forumAdmin) {
		return sqlSession.insert("mapper.admin.form_admin_create", forumAdmin);
	}
	@Override
	public int adminforumdelete(int forum_id) {
		return sqlSession.delete("mapper.admin.form_admin_delete", forum_id);
	}
	@Override
	public List<SectionAdmin> adminsectionlist() {
		return sqlSession.selectList("mapper.admin.section_admin_list");
	}
	@Override
	public int adminsectioncreate(SectionAdmin sectionAdmin) {
		return sqlSession.insert("mapper.admin.section_admin_create", sectionAdmin);
	}
	@Override
	public int adminsectiondelete(int section_id) {
		return sqlSession.delete("mapper.admin.section_admin_delete", section_id);
	}

}
