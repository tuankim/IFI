package com.ifisolution.swbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifisolution.swbackend.model.UserMst;
import com.ifisolution.swbackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

	@Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
	}

	@Override
	public List<UserMst> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	
}
