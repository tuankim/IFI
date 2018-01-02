package com.ifisolution.swbackend.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ifisolution.swbackend.model.RequestQuestionMst;

public interface RequestQuestionService {
	RequestQuestionMst saveAnswer(RequestQuestionMst requestQuestionMst);
	
	List<RequestQuestionMst> getAllRequestQuestionMst();
	
	List<RequestQuestionMst> getAnswerForRequest(int idRequest);
}
