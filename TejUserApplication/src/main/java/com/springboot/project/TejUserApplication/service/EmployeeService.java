package com.springboot.project.TejUserApplication.service;

import java.util.List;

import com.springboot.project.TejUserApplication.entity.Employee;



public interface EmployeeService {
	List<Employee> findAll();

	Employee findById(int theid);

	Employee save(Employee theEmployee);

	Employee update(Employee theEmployee);

	void deleteById(int theid);
}
