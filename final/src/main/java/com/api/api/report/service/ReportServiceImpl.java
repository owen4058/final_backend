package com.api.api.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.report.Report;
import com.api.api.report.repository.ReportRepository;

@Service("reportService")
public class ReportServiceImpl implements ReportService{
    @Autowired
	private ReportRepository reportRepository;
  //1. 신고내용 db에 저장할 것 - saveReport
    @Override
    public int saveReport(Report report) {
        return reportRepository.saveReport(report);
    }
 //2, //2. 관리자 페이지에 리스트 띄어주기
    @Override
  public List<Report> getListReport() {
      return reportRepository.findListByAdmin();
  }
  //3. 신고된 내용 불러오기
    @Override
    public Report getDetail(int report_id) {
        return reportRepository.findById(report_id);
    }

}
