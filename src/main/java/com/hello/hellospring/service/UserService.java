package com.hello.hellospring.service;

import com.hello.hellospring.model.User;

public interface UserService {

	void save(User user);
	
	User findById(int id);
	
	User findBySso(String sso);
	
}