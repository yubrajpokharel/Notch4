package com.hello.hellospring.dao;

import com.hello.hellospring.model.User;


public interface UserDao {

	void save(User user);
	
	User findById(int id);
	
	User findBySSO(String sso);
	
}

