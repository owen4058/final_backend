package com.api.api.report.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.report.Report;

public interface ReportRepository {
	public int saveReport(Report report) throws DataAccessException;
	public List<Report> findListByAdmin() throws DataAccessException;
	public int processReport(Report report) throws DataAccessException;
	
	
	public Report findById(int report_id) throws DataAccessException;
	
}
