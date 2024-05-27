package com.api.api.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.api.api.report.Report;
import com.api.api.report.service.ReportService;


@Controller("reportController")
public class ReportControllerImpl implements ReportController {

	@Autowired
	private ReportService reportService;
	@PostMapping("")
    @Override
    public ResponseEntity<Report> saveReport(@RequestBody Report report) {
        int result = reportService.saveReport(report);
        if (result > 0) {
            return ResponseEntity.ok(report);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
	@GetMapping("/admin/")
	@Override
	public ResponseEntity<List<Report>> getListReport() {
		List<Report> reportList = reportService.getListReport();
		if (!reportList.isEmpty()) {
			return ResponseEntity.ok(reportList);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/admin/Report/{id}")
	@Override
	public ResponseEntity<Report> getDetail(@RequestParam int report_id) {
		Report report = reportService.getDetail(report_id);
		if (report != null) {
			return ResponseEntity.ok(report);
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	
}
