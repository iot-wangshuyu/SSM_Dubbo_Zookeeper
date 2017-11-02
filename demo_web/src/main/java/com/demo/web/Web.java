package com.demo.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.User;
import com.demo.service.UserService;
import com.shuyu.redis.cluster.RedisCluster;
import com.shuyu.utils.GsonUtil;

@Controller
@RequestMapping(value="/test")
public class Web {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	@Qualifier("redisCluster")  
//	private RedisCluster redisCluster;
	
	@RequestMapping(value="/users")
	@ResponseBody
	public List<User> queryAll(){
		List<User> listUser = userService.getListUser();
//		System.out.println(redisCluster);
		return listUser;
	}
	@RequestMapping(value="/user")
	@ResponseBody
	public String queryUser(){
		return userService.queryUser().getUserName();
	}
	@RequestMapping(value="/redis")
	@ResponseBody
	public List<User> queryRedis(){
		List<User> listUser=null;
//		if (object==null) {
			listUser = userService.getCacheListUser();
//		}else {
//			listUser=GsonUtil.GsonToList(GsonUtil.GsonString(object), User.class);
//		}
		
		return listUser;
	}

}
