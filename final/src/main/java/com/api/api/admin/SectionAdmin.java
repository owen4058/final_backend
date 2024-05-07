package com.api.api.admin;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("sectionAdmin")
@Getter
@Setter

public class SectionAdmin {
	
	int forum_id;
	int section_id;
	String section_name;
	Date create_date;
	
}
