package com.ifisolution.swbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifisolution.swbackend.model.RequestMst;

public interface RequestRepository extends JpaRepository<RequestMst, Integer>{

}
