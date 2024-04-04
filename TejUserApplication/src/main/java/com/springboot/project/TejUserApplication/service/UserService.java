package com.springboot.project.TejUserApplication.service;

import com.springboot.project.TejUserApplication.entity.User;

public interface UserService {
	public User saveUser(User user);

	public boolean existEmailCheck(String email);
}
