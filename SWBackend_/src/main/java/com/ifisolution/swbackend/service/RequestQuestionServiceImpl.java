package com.ifisolution.swbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifisolution.swbackend.model.RequestQuestionMst;
import com.ifisolution.swbackend.repository.RequestQuestionRepository;

@Service
public class RequestQuestionServiceImpl implements RequestQuestionService{
	private RequestQuestionRepository requestQuestionRepository;

	@Autowired
    public void setQuestionRepository(RequestQuestionRepository requestQuestionRepository) {
        this.requestQuestionRepository = requestQuestionRepository;
	}

	@Override
	public List<RequestQuestionMst> getAllRequestQuestionMst() {
		// TODO Auto-generated method stub
		return requestQuestionRepository.findAll();
	}
	
	
	public List<RequestQuestionMst> getAnswerForRequest(int idRequest){
		return requestQuestionRepository.getAnswerForRequest(idRequest);
	}

	@Override
	public RequestQuestionMst saveAnswer(RequestQuestionMst requestQuestionMst) {
		// TODO Auto-generated method stub
		return requestQuestionRepository.save(requestQuestionMst);
	}
	
	
}
