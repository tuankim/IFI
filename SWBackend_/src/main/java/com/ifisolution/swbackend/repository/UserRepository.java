package com.ifisolution.swbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifisolution.swbackend.model.UserMst;

public interface UserRepository extends JpaRepository<UserMst, Integer>{

}
