package com.api.api.report.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.qna.Qna;
import com.api.api.report.Report;

@Repository("reportRepository")
public class ReportRepositoryImpl implements ReportRepository {
	
	@Autowired
	private SqlSession sqlSession;
	//1. 신고내용 db에 저장할 것 - saveReport
	@Override
    public int saveReport(Report report) {
		return sqlSession.insert("mapper.report.insertReport", report);
    }
	//2. 관리자 페이지에 리스트 띄우기
	 @Override
	    public List<Report> findListByAdmin() {
	        return sqlSession.selectList("mapper.report.selectReportListByAdmin");
	    }
	//3. 신고 처리 여부
	 @Override
	 public int processReport(Report report) {
	        return sqlSession.update("mapper.report.updateReport", report);
	    }
	 
	 
	 
	 
	 
	 @Override
    public Report findById(int report_id) {
       return sqlSession.selectOne("mapper.report.selectReport", report_id);
    }


}
