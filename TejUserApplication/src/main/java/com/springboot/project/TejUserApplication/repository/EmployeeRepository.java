package com.springboot.project.TejUserApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.TejUserApplication.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
