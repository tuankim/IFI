package com.ifisolution.swbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifisolution.swbackend.model.DocumentMst;

public interface DocumentRepository extends JpaRepository<DocumentMst, Integer>{

}
