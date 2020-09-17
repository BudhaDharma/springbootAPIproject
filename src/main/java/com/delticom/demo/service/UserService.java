package com.delticom.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delticom.demo.model.User;
import com.delticom.demo.repository.UserRepository;

@Service 
public class UserService {
	
	@Autowired
	private UserRepository urepo;
	
	public User isUserExists(String username) {
		return urepo.findByUserName(username);
	}

}
