package com.springboot.project.TejUserApplication.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.TejUserApplication.entity.Employee;
import com.springboot.project.TejUserApplication.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository theEmployeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		super();
		this.theEmployeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return theEmployeeRepository.findAll();
	}

	@Override
	public Employee findById(int theid) {
		return theEmployeeRepository.findById(theid).get();
	}

	@Override
	public Employee save(Employee theEmployee) {
		return theEmployeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theid) {
		theEmployeeRepository.deleteById(theid);
	}

	@Override
	public Employee update(Employee theEmployee) {
		// TODO Auto-generated method stub
		return theEmployeeRepository.save(theEmployee);
	}

}
