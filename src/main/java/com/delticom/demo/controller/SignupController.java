package com.delticom.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delticom.demo.model.User;
import com.delticom.demo.repository.UserRepository;
import com.delticom.demo.service.UserService;

@Controller
public class SignupController {
	
	@Autowired
	private UserService uservice;
	
	@Autowired
	private UserRepository urepo;
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User user,Model model) {
		
		
		if(uservice.isUserExists(user.getUserName()) == null) {
			urepo.save(user);
			model.addAttribute("error","user saved successfully, Please login");
			return "login";
		}
		model.addAttribute("error","user already taken, please choose another");
		return "signup";
	}

}
