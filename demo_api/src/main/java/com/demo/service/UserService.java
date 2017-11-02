package com.demo.service;

import java.util.List;

import com.demo.pojo.User;

public interface UserService {
	List<User> getListUser();
	
	User queryUser();
	
	List<User> getCacheListUser();

}
