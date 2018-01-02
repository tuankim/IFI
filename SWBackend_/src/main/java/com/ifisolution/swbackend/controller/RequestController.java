package com.ifisolution.swbackend.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.swbackend.model.QuestionMst;
import com.ifisolution.swbackend.model.RequestMst;
import com.ifisolution.swbackend.model.RequestQuestionMst;
import com.ifisolution.swbackend.service.RequestQuestionService;
import com.ifisolution.swbackend.service.RequestService;

@RestController
@RequestMapping("Request")
public class RequestController {
	@Autowired
	RequestService rerquestService;
	
	@Autowired
	RequestQuestionService requestQuestionService;

	// get list CardCenters //
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RequestMst>> listAll() {
		List<RequestMst> listAllRequest = rerquestService.getAllRequest();
		System.out.println(listAllRequest.size());
		if (listAllRequest.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RequestMst>>(listAllRequest, HttpStatus.OK);
	}
	
	@GetMapping("get")
	public List<RequestQuestionMst> getAllRequestQuestion() {
	    return requestQuestionService.getAllRequestQuestionMst();
	}
	
	
	@GetMapping("get/{id}")
	public List<RequestQuestionMst> getAllRequestQuestion(@PathVariable("id") Integer id) {
	    return requestQuestionService.getAnswerForRequest(id);
	}
	
	@PutMapping("get")
	public ResponseEntity<?> addAnswer(@RequestBody RequestMst requestMst) {
		List<RequestQuestionMst> listRequestQuestionMst=requestQuestionService.getAnswerForRequest(requestMst.getRequestId());
		System.out.println("ak"+listRequestQuestionMst.size());
		Set<QuestionMst> set=requestMst.getQuestionMsts();
		List<QuestionMst> listQuestion=new ArrayList<>(set);
		for (RequestQuestionMst requestQuestionMst : listRequestQuestionMst) {
			
			for (QuestionMst questionMst : listQuestion) {
				if(requestQuestionMst.getId().getQuestionId()==questionMst.getQuestionId()) {
					requestQuestionMst.setAnswerContent(questionMst.getAnswerContent().get(0));
					requestQuestionService.saveAnswer(requestQuestionMst);
					break;
				}
			}
		}
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@PutMapping("create")
	public ResponseEntity<?> createTransactionData(@RequestBody RequestMst requestMst) {
		rerquestService.saveRequest(requestMst);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}