package com.springboot.project.TejUserApplication.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.project.TejUserApplication.entity.Employee;
import com.springboot.project.TejUserApplication.entity.User;
import com.springboot.project.TejUserApplication.repository.UserRepository;
import com.springboot.project.TejUserApplication.service.EmployeeService;

@Controller
public class RoleController {
	private EmployeeService employeeService;

	public RoleController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

//	@GetMapping("/employees")
//	public String listEmployees(Model model) {
//		List<Employee> theEmployees = employeeService.findAll();
//		model.addAttribute("employees", theEmployees);
//		return "employee";
//	}

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute
	public void getUser(User u, Model m) {
		String email = u.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);

	}

	@GetMapping("/admin")
	public String admins(Model model) {
		List<Employee> theEmployees = employeeService.findAll();
		model.addAttribute("employees", theEmployees);
		return "admin";
	}

	@GetMapping("/manager")
	public String managers(Model model) {
		List<Employee> theEmployees = employeeService.findAll();
		model.addAttribute("employees", theEmployees);
		return "manager";
	}

	@GetMapping("/employee")
	public String profile(Model model) {
		List<Employee> theEmployees = employeeService.findAll();
		model.addAttribute("employees", theEmployees);

		return "employee";
	}

}