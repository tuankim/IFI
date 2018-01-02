package com.ifisolution.swbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifisolution.swbackend.model.QuestionMst;

public interface QuestionRepository extends JpaRepository<QuestionMst, Integer>{
	
}
