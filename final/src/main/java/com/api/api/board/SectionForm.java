package com.api.api.board;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("sectionForm")
@Getter
@Setter

public class SectionForm {
	int section_id;
	String section_name;
}
