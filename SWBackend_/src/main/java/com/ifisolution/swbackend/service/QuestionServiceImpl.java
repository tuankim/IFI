package com.ifisolution.swbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifisolution.swbackend.model.QuestionMst;
import com.ifisolution.swbackend.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
	private QuestionRepository questionRepository;

	@Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
	}

	@Override
	public List<QuestionMst> getAllQuestion() {
		// TODO Auto-generated method stub
		List<QuestionMst> listQuestion=questionRepository.findAll();
		for (QuestionMst questionMst : listQuestion) {
			List<String> anwers=new ArrayList<>();
			if(questionMst.getListAnswer() != null) {
				String[]  listAnswer= questionMst.getListAnswer().split(",");
				for(String answer:listAnswer) {
					anwers.add(answer);
				}
			}
			questionMst.setAnwers(anwers);
		}
		for (int i = 0; i < listQuestion.size(); i++) {
			if(listQuestion.get(i).getQuestionParentId()!=0) {
				for (QuestionMst questionMst_ : listQuestion) {
					if(questionMst_.getQuestionId()==listQuestion.get(i).getQuestionParentId()) {
						questionMst_.getQuestionSub().add(listQuestion.get(i));
					}
				}
				listQuestion.remove(listQuestion.get(i));
				i--;
			}		
		}
		
		return listQuestion;
	}
}
