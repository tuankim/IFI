package com.ifisolution.swbackend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifisolution.swbackend.model.UserMst;
import com.ifisolution.swbackend.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin("http://localhost:8086")
public class UserController {
	@Autowired
	UserService userService;

	//	get list CardCenters //
	@GetMapping("")
	public List<UserMst> getAllUser() {
	    return userService.getAllUser();
	}
	
	@PostMapping("/login")
	public UserMst createNote(@Valid @RequestBody UserMst user) {
		List<UserMst> listUsers=new ArrayList<UserMst>();
		listUsers=userService.getAllUser();
		UserMst userFind = new UserMst();
		for(UserMst usr: listUsers){
			if(user.getUserName().equals(usr.getUserName()) && user.getPassword().equals(usr.getPassword())) {
				userFind = usr;
			}
		}
		System.out.println("userFind=="+userFind);
		return userFind;
	}
}
