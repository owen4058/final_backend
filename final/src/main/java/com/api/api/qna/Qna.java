package com.api.api.qna;

import java.util.Date;

import org.springframework.stereotype.Component;


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
	boolean has_answer;
	Date asked_date;
	String answer_content;
	Date answer_date;
}
