package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.UserService;
/**
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author shuyu.wang
 * @date 2017年10月31日 下午6:10:06 
 * @version V1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override 
	public List<User> getListUser() {
		List<User> listUser=null;
		try {
			listUser = userMapper.getListUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;				
	}

	@Override
	public User queryUser() {
		User user=new User();
		user.setUserName("name");
		return user;
	}
	
	
}
