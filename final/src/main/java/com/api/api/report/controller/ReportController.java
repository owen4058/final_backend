package com.api.api.report.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.api.report.Report;

public interface ReportController {

	public ResponseEntity<Report> saveReport(Report report);
	public ResponseEntity<List<Report>> getListReport();
	public ResponseEntity<Report> getDetail(int report_id);
}
