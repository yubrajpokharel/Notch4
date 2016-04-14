package com.hello.hellospring.dao;

import java.util.List;

import com.hello.hellospring.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
