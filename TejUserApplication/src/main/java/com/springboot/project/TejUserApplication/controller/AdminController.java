package com.springboot.project.TejUserApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.project.TejUserApplication.entity.Employee;
import com.springboot.project.TejUserApplication.entity.User;
import com.springboot.project.TejUserApplication.repository.UserRepository;
import com.springboot.project.TejUserApplication.service.EmployeeService;
@Controller
@RequestMapping("/admin")
public class AdminController {
	private EmployeeService employeeService;

	public AdminController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute
	public void getUser(User u, Model m) {
		String email = u.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);

	}

	@GetMapping("/employees")
	public String admins(Model model) {
		List<Employee> theEmployees = employeeService.findAll();
		model.addAttribute("employees", theEmployees);
		return "/Admin/adminpage";
	}

	@GetMapping("/employee/new")
	public String createEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "/Admin/addbyAdmin";
	}

	@PostMapping("/employees")
	public String SaveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/admin/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String editStudent(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.findById(id));
		return "/Admin/updatebyAdmin";
	}

	@PostMapping("/employees/{id}")
	public String UpdateStudent(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {
		Employee existingEmployee = employeeService.findById(id);
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setPhoneno(employee.getPhoneno());
		employeeService.update(existingEmployee);
		return "redirect:/admin/employees";
	}

	@GetMapping("/employees/{id}")
	public String DeleteEmployee(@PathVariable int id) {
		employeeService.deleteById(id);
		return "redirect:/admin/employees";
	}
}
