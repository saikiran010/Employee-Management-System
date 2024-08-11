package com.example.employeemanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.employeemanagement.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(long id);
	
	public Employee save(Employee emp);
	
	public Employee updateEmployeeById(long id,Employee emp);
	
	public void deleteEmployeeById(long id);


}
