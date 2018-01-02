package com.ifisolution.swbackend.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.swbackend.model.QuestionMst;
import com.ifisolution.swbackend.model.RequestMst;
import com.ifisolution.swbackend.service.QuestionService;
import com.ifisolution.swbackend.service.RequestService;

@RestController
@RequestMapping("question")
@CrossOrigin("http://localhost:8086")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@Autowired
	RequestService requestService;

	//	get list CardCenters //
	@GetMapping("/listQuestion")
	public List<QuestionMst> getAllQuestion() {
	    return questionService.getAllQuestion();
	}
	
	@GetMapping("getQuestionByRequest/{id}")
	public Set<QuestionMst> getTeamplateByRequest(@PathVariable("id") Integer id) {
		System.out.println("vao day"+ id);
		Set<QuestionMst> listQuestion4Request = requestService.findOne(id).getQuestionMsts();
		if (listQuestion4Request == null) {
			listQuestion4Request = new HashSet<QuestionMst>(0);
		}
		return listQuestion4Request;
	}
	
	// put question for request
	@PutMapping("assignQuestion")
	public RequestMst assignQuestion(@RequestBody RequestMst requestMst) {
		System.out.println("ssssssssss"+requestMst.getRequestId());
		System.out.println("ssssssssss:"+requestMst.getQuestionMsts().size());
		try {
//			logger.info("requestQuestion==" + requestMst.getRequestId());
//			logger.info("requestQuestion==" + requestMst.getListQuestionAnwers());
			RequestMst request = requestService.findOne(requestMst.getRequestId());
			System.out.println("ssssssssss:"+request.getCompanyName());
			Set<QuestionMst> listQuestionOld = request.getQuestionMsts();
			
					
			if (listQuestionOld == null) {
				listQuestionOld = new HashSet<QuestionMst>(0);
			}
			
//			logger.info("requestQuestion.getListQuestionAnwers()==" + requestQuestion.getListQuestionAnwers());
			
			if (requestMst.getQuestionMsts() != null) {
				for (QuestionMst question : requestMst.getQuestionMsts()) {
					boolean checkQuestionId = true;
					for (QuestionMst questionOld : listQuestionOld) {
						if (question.getQuestionId() == questionOld.getQuestionId()) {
							checkQuestionId = false;
							break;
						}
					}
					if (checkQuestionId) {
						listQuestionOld.add(question);
					}
//					logger.info("  " + question.getAnswerContent());
				}
			}
			
//			logger.info(listQuestionOld.size());
			
			request.setQuestionMsts(listQuestionOld);
			System.out.println("ssssssssss:"+listQuestionOld.size());
			requestService.saveRequest(request);
//			modifierRequestByNewQuestion(requestQuestion.getRequestId());
		}catch(NullPointerException ex) {
//			logger.error("Exception"+ ex);
		}
		return requestMst;
	}
	
//	@PutMapping("assignAnswer")
//	public Response assignAnswer(@RequestBody RequestMst requestMst) {
//
//		try {
//			logger.info("requestQuestion==" + requestQuestion.getRequestId());
//			logger.info("requestQuestion==" + requestQuestion.getListQuestionAnwers());
//			
//			List<QuestionAnwers> listQuestionOld = DataModel.getInstance().getQuestion4Request()
//					.get(requestQuestion.getRequestId());
//			if (listQuestionOld == null) {
//				listQuestionOld = new ArrayList<QuestionAnwers>();
//			}
//			
//			logger.info("requestQuestion.getListQuestionAnwers()==" + requestQuestion.getListQuestionAnwers());
//			
//			if (requestQuestion.getListQuestionAnwers() != null) {
//				listQuestionOld = requestQuestion.getListQuestionAnwers();
//				logger.info("come here answer" + listQuestionOld.get(0).getAnswerContent());
//			}
//			
//			logger.info("come here" + listQuestionOld.size());
//			
//			DataModel.getInstance().getQuestion4Request().put(requestQuestion.getRequestId(), listQuestionOld);
//		}catch(NullPointerException ex) {
//			logger.error("Exception"+ ex);
//		}
//		modifierRequestByNewQuestion(requestQuestion.getRequestId());
//		return Response.created(null).entity("Entity created successfully").build();
//
//	}
	
}