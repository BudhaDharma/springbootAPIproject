package com.delticom.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delticom.demo.model.Employee;
import com.delticom.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	
	public void  addEmployee(Employee emp) {
		emprepo.save(emp);
	}
	
	public void deleteEmployee(int id) {
		emprepo.deleteById(id);
	}
	
	public Employee getEmployeeById(int id) {
		return emprepo.getOne(id);
	}
	
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}
}
