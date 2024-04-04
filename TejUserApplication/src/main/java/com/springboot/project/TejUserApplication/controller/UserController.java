package com.springboot.project.TejUserApplication.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.project.TejUserApplication.entity.User;
import com.springboot.project.TejUserApplication.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute
	public void getUser(User u, Model m) {
		String email = u.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);

	}

}