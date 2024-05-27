package com.api.api.report.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.api.report.Report;

public interface ReportController {

	public ResponseEntity<Report> saveReport(Report report) throws Exception;
	public ResponseEntity<List<Report>> getListReport() throws Exception;
	public ResponseEntity<Report> getDetail(int report_id) throws Exception;
}
