package com.api.api.qna.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.api.api.qna.Qna;

public interface QnaRepository {
	public int saveQuestion(Qna qna) throws DataAccessException;
	public int editQuestion(Qna qna) throws DataAccessException;
	public int saveAnswer(Qna qna) throws DataAccessException;
	public int editAnswer(Qna qna) throws DataAccessException;
    public Qna findDetail(int question_id) throws DataAccessException;
    public List<Qna> findList(int user_id) throws DataAccessException;
}
