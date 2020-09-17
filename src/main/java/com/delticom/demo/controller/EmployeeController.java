package com.delticom.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.delticom.demo.model.Employee;
import com.delticom.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	@GetMapping("/employee")
	public String employeeForm(Model model) {
		model.addAttribute("employee",new Employee());
		return "employee_form";
	}
	
	//TODO: Improve GUI with Bootstrap {tomorrow 10 Sep 2020}
	//TODO: REST API
	
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute Employee emp) {
		
		empservice.addEmployee(emp);
		
		return "redirect:/list";
		
	}
	
	@GetMapping("/list")
	public String getAll(Model model, HttpSession session) {
		
		if(!StringUtils.isEmpty(session.getAttribute("userlogin"))){
			model.addAttribute("elist",empservice.getAllEmployee());
			return "employeeList";
		}
		return "login";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id, Model model) {
		empservice.deleteEmployee(id);
		
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model) {
	
		model.addAttribute("employee",  empservice.getEmployeeById(id));
		return "employee_form";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "login";
	}
	
}
