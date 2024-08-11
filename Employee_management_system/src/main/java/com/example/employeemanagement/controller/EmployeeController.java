package com.example.employeemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {
   
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService=employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		
		return ResponseEntity.ok(employeeService.findById(id));
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee emp){
		 return ResponseEntity.ok(employeeService.updateEmployeeById(id, emp));
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteById(@PathVariable long id){
		employeeService.deleteEmployeeById(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
}


