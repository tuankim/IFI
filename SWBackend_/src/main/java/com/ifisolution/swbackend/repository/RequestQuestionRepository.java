package com.ifisolution.swbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifisolution.swbackend.model.RequestQuestionMst;
import com.ifisolution.swbackend.model.RequestQuestionMstId;

public interface RequestQuestionRepository extends JpaRepository<RequestQuestionMst, RequestQuestionMstId>{
	@Query("select u from RequestQuestionMst u where u.id.requestId = :#{#idRequest}")
	List<RequestQuestionMst> getAnswerForRequest(@Param("idRequest") int idRequest);
}
