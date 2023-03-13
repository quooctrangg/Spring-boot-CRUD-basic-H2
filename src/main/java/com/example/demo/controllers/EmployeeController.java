package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService iEmployeeService;

	@GetMapping("/")
	public String test() {
		return "Hello";
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return iEmployeeService.addEmployee(employee);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee employee) {
		return iEmployeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean DeleteEmployee(@PathVariable("id") long id) {
		return iEmployeeService.deleteEmployee(id);
	}
	
	@GetMapping("/list")
	public List<Employee> getEmployees(){
		return iEmployeeService.getAllEmployees();
	}
}
