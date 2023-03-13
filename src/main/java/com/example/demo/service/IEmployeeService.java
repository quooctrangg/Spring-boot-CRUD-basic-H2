package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(long id, Employee employee);

	public boolean deleteEmployee(long id);

	public List<Employee> getAllEmployees();

	public Employee getOneEmployee(long id);
}
