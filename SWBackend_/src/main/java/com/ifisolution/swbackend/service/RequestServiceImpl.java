package com.ifisolution.swbackend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifisolution.swbackend.model.QuestionMst;
import com.ifisolution.swbackend.model.RequestMst;
import com.ifisolution.swbackend.repository.QuestionRepository;
import com.ifisolution.swbackend.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	private RequestRepository requestRepository;
	private QuestionRepository questionRepository;

	@Autowired
	public void setRequestRepository(RequestRepository requestRepository, QuestionRepository questionRepository) {
		this.requestRepository = requestRepository;
		this.questionRepository = questionRepository;
	}

	@Override
	public List<RequestMst> getAllRequest() {
		// TODO Auto-generated method stub
		return requestRepository.findAll();
	}

	@Override
	public RequestMst findOne(int id) {
		// TODO Auto-generated method stub
		RequestMst requestmst = requestRepository.findOne(id);
		Set<QuestionMst> set_question = requestmst.getQuestionMsts();
		List<QuestionMst> listQuestion = new ArrayList<>(set_question);
		
		List<QuestionMst> listAllQuestion=questionRepository.findAll();
		for (QuestionMst questionMst : listQuestion) {
			List<String> anwers = new ArrayList<>();
			if (questionMst.getListAnswer() != null) {
				String[] listAnswer = questionMst.getListAnswer().split(",");
				for (String answer : listAnswer) {
					anwers.add(answer);
				}
			}
			questionMst.setAnwers(anwers);
		}
		
		for (QuestionMst questionMst : listAllQuestion) {
			if(questionMst.getQuestionParentId()!=0) {
				for (QuestionMst questionMst_ : listQuestion) {
					if(questionMst.getQuestionParentId()==questionMst_.getQuestionId()) {
						questionMst_.getQuestionSub().add(questionMst);
					}
				}
			}
		}
		
		Set<QuestionMst> set = new HashSet<QuestionMst>(listQuestion);
		requestmst.setQuestionMsts(set);
		return requestmst;
	}

	@Override
	public RequestMst saveRequest(RequestMst requestMst) {
		// TODO Auto-generated method stub
		return requestRepository.save(requestMst);
	}

}
