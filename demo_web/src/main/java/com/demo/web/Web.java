package com.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.User;
import com.demo.service.UserService;

@Controller
@RequestMapping(value="/test")
public class Web {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users")
	@ResponseBody
	public List<User> queryAll(){
		List<User> listUser = userService.getListUser();
		return listUser;
	}
	@RequestMapping(value="/user")
	public String queryUser(){
		return userService.queryUser().getUserName();
	}

}
