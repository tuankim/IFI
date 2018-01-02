package com.ifisolution.swbackend.service;

import java.util.List;

import com.ifisolution.swbackend.model.RequestMst;

public interface RequestService {
	
	List<RequestMst> getAllRequest();
	
	RequestMst findOne(int id);
	
	RequestMst saveRequest(RequestMst requestMst);
	
	
}
