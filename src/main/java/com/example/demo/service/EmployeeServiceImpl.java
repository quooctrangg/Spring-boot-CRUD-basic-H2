package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		if (employee != null) {
			return employeeRepository.save(employee);
		}
		return null;
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		if (employee != null) {
			Employee employee1 = employeeRepository.getById(id);
			if (employee1 != null) {
				employee1.setName(employee.getName());
				employee1.setAddress(employee.getAddress());

				return employeeRepository.save(employee1);
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(long id) {
		if (id >= 1) {
			Employee employee = employeeRepository.getById(id);
			if (employee != null) {
				employeeRepository.delete(employee);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getOneEmployee(long id) {
		return employeeRepository.getById(id);
	}
}
