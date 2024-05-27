package com.api.api.report;

import java.util.Date;

import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("Report")
@Getter
@Setter
@NoArgsConstructor
public class Report {
	int report_id;
	int user_id;
	String report_reason;
	String content;
	Date create_date;
	int board_id;
	String reporter_email;
	String reported_email;
}