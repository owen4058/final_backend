package com.api.api.qna.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.qna.Qna;

public interface QnaController {
	public ResponseEntity<Qna> createQuestion(Qna qna) throws Exception;
	public ResponseEntity<Qna> updateQuestion(Qna qna) throws Exception;
	public ResponseEntity<Qna> createAnswer(Qna qna) throws Exception;
	public ResponseEntity<Qna> updateAnswer(Qna qna) throws Exception;
	public ResponseEntity<Qna> getQuestionDetails(int question_id) throws Exception;
	public ResponseEntity<List<Qna>> getQuestionListByUser(int user_id) throws Exception;
	public ResponseEntity<List<Qna>> getQuestionListByAdmin() throws Exception;
	
}
