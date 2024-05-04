package com.api.api.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.qna.Qna;
import com.api.api.qna.repository.QnaRepository;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{
    @Autowired
	private QnaRepository qnaRepository;

    @Override
    public int createQuestion(Qna qna) {
        return qnaRepository.saveQuestion(qna);
    }

    @Override
    public int updateQuestion(Qna qna) {
        return qnaRepository.editQuestion(qna);
    }

    @Override
    public int createAnswer(Qna qna) {
        return qnaRepository.saveAnswer(qna);
    }

    @Override
    public int updateAnswer(Qna qna) {
        return qnaRepository.editAnswer(qna);
    }

    @Override
    public Qna getQuestionDetails(int question_id) {
        return qnaRepository.findDetail(question_id);
    }

    @Override
    public List<Qna> getQuestionListByUser(int user_id) {
        return qnaRepository.findListByUser(user_id);
    }
    @Override
    public List<Qna> getQuestionListByAdmin() {
        return qnaRepository.findListByAdmin();
    }
}
