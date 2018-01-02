package com.ifisolution.swbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifisolution.swbackend.model.DocumentMst;
import com.ifisolution.swbackend.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService{
	private DocumentRepository documentRepository;

	@Autowired
    public void setRDocumentRepository(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
	}

	@Override
	public List<DocumentMst> getAllDocument() {
		// TODO Auto-generated method stub
		return documentRepository.findAll();
	}
}
