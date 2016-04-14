package com.hello.hellospring.service;

import java.util.List;

import com.hello.hellospring.model.UserProfile;

public interface UserProfileService {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
