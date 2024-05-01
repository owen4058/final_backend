package com.api.api.forum;


import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("sectionForm")
@Getter
@Setter
@NoArgsConstructor

public class SectionForm {
	int section_id;
	String section_name;
}
