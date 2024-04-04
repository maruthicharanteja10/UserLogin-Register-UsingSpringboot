package com.springboot.project.TejUserApplication.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.springboot.project.TejUserApplication.entity.User;
import com.springboot.project.TejUserApplication.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
	

		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public boolean existEmailCheck(String email) {
		return userRepository.existsByEmail(email);
	}

	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}
}
