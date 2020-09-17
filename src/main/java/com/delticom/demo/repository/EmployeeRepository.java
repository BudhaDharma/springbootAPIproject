package com.delticom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delticom.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
