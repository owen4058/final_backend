package com.api.api.qna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.api.qna.Qna;
import com.api.api.qna.service.QnaService;


@Controller("qnaController")
@RequestMapping("profile/qna")
public class QnaControllerImpl implements QnaController {
	@Autowired
    private QnaService qnaService;

	//get qna List(Answer X) in qna tab in MyPage
	@GetMapping("")
	@Override
	public ResponseEntity<List<Qna>> getQuestionList(@RequestParam int user_id) {
		List<Qna> qnaList = qnaService.getQuestionList(user_id);
		if (!qnaList.isEmpty()) {
			return ResponseEntity.ok(qnaList);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//get qna Detail(Answer O) in MyPage
	@GetMapping("/detail/{question_id}")
	@Override
	public ResponseEntity<Qna> getQuestionDetails(@RequestParam int question_id) {
		Qna qna = qnaService.getQuestionDetails(question_id);
		if (qna != null) {
			return ResponseEntity.ok(qna);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//create qna
    @PostMapping("/detail")
    @Override
    public ResponseEntity<Qna> createQuestion(@RequestBody Qna qna) {
        int result = qnaService.createQuestion(qna);
        if (result > 0) {
            return ResponseEntity.ok(qna);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //edit qna
    @PutMapping("/detail")
    @Override
    public ResponseEntity<Qna> updateQuestion(@RequestBody Qna qna) {
        int result = qnaService.updateQuestion(qna);
        if (result > 0) {
            return ResponseEntity.ok(qna);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    
    @PostMapping("/detail/admin")
    @Override
    public ResponseEntity<Qna> createAnswer(@RequestBody Qna qna) {
        int result = qnaService.createAnswer(qna);
        if (result > 0) {
            return ResponseEntity.ok(qna);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/detail/admin")
    @Override
    public ResponseEntity<Qna> updateAnswer(@RequestBody Qna qna) {
        int result = qnaService.updateAnswer(qna);
        if (result > 0) {
            return ResponseEntity.ok(qna);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}