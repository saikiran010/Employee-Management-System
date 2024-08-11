package com.example.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
    
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findById(long id) {
		Optional<Employee> emp=employeeRepo.findById(id);
		Employee employee;
	    if(emp.isPresent())
	    	employee=emp.get();
	    else
	    	throw new ResourceNotFoundException("Employee not found with id "+id);
	    return employee;
	}

	@Override
	public Employee save(Employee emp) {
		 return employeeRepo.save(emp);
	}

	@Override
	public Employee updateEmployeeById(long id, Employee employeeNewDetails) {
		Employee emp= employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not Exist with id "+id));
		emp.setFirstName(employeeNewDetails.getFirstName());
		emp.setLastName(employeeNewDetails.getLastName());
		emp.setEmailId(employeeNewDetails.getEmailId());
		return employeeRepo.save(emp);
	}

	@Override
	public void deleteEmployeeById(long id) {
		
		Employee emp=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id "+id));
		
		employeeRepo.delete(emp);
	}
     
	
}
