package com.api.api.qna.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.api.qna.Qna;

@Repository("qnaRepository")
public class QnaRepositoryImpl implements QnaRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
    public int saveQuestion(Qna qna) {
		return sqlSession.insert("mapper.qna.insertQuestion", qna);
    }

	// Only can edit contents(Title edit X)
    @Override
    public int editQuestion(Qna qna) {
    	return sqlSession.update("mapper.qna.updateQuestion", qna);
    }
    
    @Override
    public int saveAnswer(Qna qna) {
    	return sqlSession.insert("mapper.qna.insertAnswer", qna);
    }

    @Override
    public int editAnswer(Qna qna) {
    	return sqlSession.update("mapper.qna.updateAnswer", qna);
    }

    @Override
    public Qna findDetail(int question_id) {
        return sqlSession.selectOne("mapper.qna.selectDetail", question_id);
    }

    @Override
    public List<Qna> findList(int user_id) {
        return sqlSession.selectList("mapper.qna.selectQuestionList", user_id);
    }
	
	

}
