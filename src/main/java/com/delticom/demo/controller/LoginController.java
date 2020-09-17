package com.delticom.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.delticom.demo.model.User;
import com.delticom.demo.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository urepo;
	
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public  String checkUser(@ModelAttribute User user,Model model, HttpSession session) {
		
		
		if(urepo.isExist(user.getUserName(), user.getPassword()) != null ) {
		//if(urepo.findByUserNameAndPassword(user.getUserName(), user.getPassword()) != null) {
			
			session.setAttribute("userlogin", user.getUserName());
			model.addAttribute("user",user.getUserName());
			//model.addAttribute("welcome","Welcome");
			return "home";
		}
		
		model.addAttribute("error","user does not exist");
		return "login";
	}

	/*Login Homework: Friday, 4Sep2020*/
}
