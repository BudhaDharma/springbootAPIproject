package com.delticom.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.delticom.demo.model.Employee;
import com.delticom.demo.repository.EmployeeRepository;
import com.delticom.demo.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService  empService;
	
	@Autowired
	private EmployeeRepository  empRepo;
	
	@GetMapping("/employee/list")
	public List<Employee> getAllEmp() {
		
		
		return empService.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public   ResponseEntity<Employee> getOneEmployee(@PathVariable("id") int id) throws Exception{
		//ResponseEntity<Employee>  emp = new ResponseEntity<Employee>(empService.getAllEmployee(),HttpStatus.OK);
		Employee emp = empRepo.findById(id).orElseThrow(()-> new Exception()) ;
		return ResponseEntity.ok().body(emp);
		//return empRepo.findById(id);
	}
	
	@PostMapping("/employee/add")
	public String saveEmployee(@RequestBody Employee emp) {
	
		empService.addEmployee(emp);
		return "Added Successfully";
	}
	
	@GetMapping("/employee/delete/{id}")
	public String  deleteEmployee(@PathVariable("id") int id) {
		
		empService.deleteEmployee(id);
		return "Employee Deleted Successfully";
	}
	

}
