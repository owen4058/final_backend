package com.api.api.admin.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.admin.ForumAdmin;
import com.api.api.admin.SectionAdmin;
import com.api.api.member.Member;

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
	@Override
	public int adminsectionedit(SectionAdmin sectionAdmin) {
		return sqlSession.update("mapper.admin.section_admin_edit", sectionAdmin);
	}
	@Override
	public int adminforumedit(ForumAdmin forumAdmin) {
		return sqlSession.update("mapper.admin.form_admin_edit", forumAdmin);
	}

	@Override
	public ForumAdmin adminforumcheck(ForumAdmin forumAdmin) {
		return sqlSession.selectOne("mapper.admin.form_logo_check",forumAdmin);
	}
	@Override
	public List<Member> deletememberlist() {
		return sqlSession.selectList("mapper.admin.delete_member_list");
	}
	@Override
	public int roleuser(int user_id) {
		return sqlSession.update("mapper.admin.Role_member",user_id);
	}
	@Override
	public int recovermember(int user_id) {
		return sqlSession.update("mapper.admin.recover_member",user_id);
	}

}
