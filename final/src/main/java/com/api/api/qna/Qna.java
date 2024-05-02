package com.api.api.qna;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.api.forum.SectionForm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("Qna")
@Getter
@Setter
@NoArgsConstructor
public class Qna {
	int question_id;
	String question_title;
	String question_content;
	int user_id;
	String nickname;
	boolean is_answer;
	Date asked_date;
	String answer_content;
	String answer_date;
}
