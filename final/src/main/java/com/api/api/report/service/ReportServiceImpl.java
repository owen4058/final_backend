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
  //1. �Ű��� db�� ������ �� - saveReport
    @Override
    public int saveReport(Report report) {
        return reportRepository.saveReport(report);
    }
 //2, //2. ������ �������� ����Ʈ ����ֱ�
    @Override
  public List<Report> getListReport() {
      return reportRepository.findListByAdmin();
  }
  //3. �Ű�� ���� �ҷ�����
    @Override
    public Report getDetail(int report_id) {
        return reportRepository.findById(report_id);
    }

}
