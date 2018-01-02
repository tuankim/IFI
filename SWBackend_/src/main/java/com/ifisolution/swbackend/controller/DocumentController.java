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

import com.ifisolution.swbackend.model.DocumentMst;
import com.ifisolution.swbackend.model.QuestionMst;
import com.ifisolution.swbackend.model.RequestMst;
import com.ifisolution.swbackend.service.DocumentService;
import com.ifisolution.swbackend.service.RequestService;

@RestController
@RequestMapping("document")
@CrossOrigin("http://localhost:8086")
public class DocumentController {
	@Autowired
	DocumentService documentService;

	@Autowired
	RequestService requestService;

	
//	private List<DocumentMst> listDocument = new ArrayList<>();
//	private List<RequestMst> listRequest =new ArrayList<>();
//	
//	
//	public DocumentController() {
//		listDocument = getAllDocument();
//		listRequest = requestService.getAllRequest();	
//	}
	
	//	get list CardCenters //
	@GetMapping("")
	public List<DocumentMst> getAllDocument() {
	    return documentService.getAllDocument();
	}
	
	@GetMapping("getTeamplateByRequest/{id}")
	public Set<DocumentMst> getTeamplateByRequest(@PathVariable("id") Integer id) {
		System.out.println("vao day"+ id);
		Set<DocumentMst> listTeamplate4Request = requestService.findOne(id).getDocumentMsts();
		if (listTeamplate4Request == null) {
			listTeamplate4Request = new HashSet<DocumentMst>(0);
		}
		return listTeamplate4Request;
	}
	
	@PutMapping("assign")
	 public RequestMst assign(@RequestBody RequestMst requestMst ) {  
		System.out.println("ssssssssss"+requestMst.getRequestId());
		System.out.println("ssssssssss:"+requestMst.getQuestionMsts().size());
		try {
//			logger.info("requestQuestion==" + requestMst.getRequestId());
//			logger.info("requestQuestion==" + requestMst.getListQuestionAnwers());
			RequestMst request = requestService.findOne(requestMst.getRequestId());
			System.out.println("ssssssssss:"+request.getCompanyName());
			Set<DocumentMst> listDocumentOld = request.getDocumentMsts();
			
					
			if (listDocumentOld == null) {
				listDocumentOld = new HashSet<DocumentMst>(0);
			}
			
//			logger.info("requestQuestion.getListQuestionAnwers()==" + requestQuestion.getListQuestionAnwers());
			
			if (requestMst.getDocumentMsts() != null) {
				for (DocumentMst document : requestMst.getDocumentMsts()) {
					boolean checkQuestionId = true;
					for (DocumentMst documentOld : listDocumentOld) {
						if (document.getDocId() == documentOld.getDocId()) {
							checkQuestionId = false;
							break;
						}
					}
					if (checkQuestionId) {
						listDocumentOld.add(document);
					}
//					logger.info("  " + question.getAnswerContent());
				}
			}
			
//			logger.info(listQuestionOld.size());
			
			request.setDocumentMsts(listDocumentOld);
			System.out.println("ssssssssss:"+listDocumentOld.size());
			requestService.saveRequest(request);
//		for(int i = 0 ; i < listRequest.size();i++) {
//			if(listRequest.get(i).getRequestId()==requestTemplate.getRequestId()) {
//				Request request = new Request();
//				request = listRequest.get(i);
//				request.setUnFinishDocument(true);
//				listRequest.set(i, request);
//			}
//		}
//		initRequestWhenSaveDocument(requestTemplate.getRequestId());
		}catch(NullPointerException ex) {
//			logger.error("Exception"+ ex);
		}
	  return requestMst;
	 }
	
//	public void initRequestWhenSaveDocument(Integer idRequest) {
//		Set<DocumentMst> listDocumentOld = requestService.findOne(idRequest).getDocumentMsts();
//		Boolean flag = false;
//		System.out.println("run initRequest_____________");
//		for(DocumentMst document : listDocumentOld) {
//			if(!document.getStatus().equals("Completed") && !document.equals("Submited")) {
//				flag =true;
//				System.out.println("run initRequest");
//			}
//		}
//		for(int i = 0 ; i < listRequest.size();i++) {
//			if(listRequest.get(i).getRequestId()==idRequest) {
//				RequestMst request = new RequestMst();
//				request = listRequest.get(i);
//				request.setUnFinishDocument(flag);
//				listRequest.set(i, request);
//			}
//		}
//	}
}
