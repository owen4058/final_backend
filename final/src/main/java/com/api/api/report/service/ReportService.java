package com.api.api.report.service;

import java.util.List;

import com.api.api.report.Report;

public interface ReportService {
	public int saveReport(Report report);
	public List<Report> getListReport();
	public Report getDetail(int report_id);

}
