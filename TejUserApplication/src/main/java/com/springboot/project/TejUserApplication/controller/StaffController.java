package com.springboot.project.TejUserApplication.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.project.TejUserApplication.entity.Employee;
import com.springboot.project.TejUserApplication.service.EmployeeService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	private EmployeeService employeeService;

	public StaffController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	
	@GetMapping("/list")
	public String profile(Model model) {
		List<Employee> theEmployees = employeeService.findAll();
		model.addAttribute("employees", theEmployees);
		return "/staff/staffpage";
	}

	
	
}
