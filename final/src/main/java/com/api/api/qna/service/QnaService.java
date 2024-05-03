package com.api.api.qna.service;

import java.util.List;

import com.api.api.qna.Qna;

public interface QnaService {
	public int createQuestion(Qna qna);
	public int updateQuestion(Qna qna);
	public int createAnswer(Qna qna);
	public int updateAnswer(Qna qna);
	public Qna getQuestionDetails(int question_id);
	public List<Qna> getQuestionListByUser(int user_id);
	public List<Qna> getQuestionListByAdmin();
}
