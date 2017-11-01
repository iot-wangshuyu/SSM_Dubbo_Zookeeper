package com.demo.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MapperTest {
	
	@Resource
	private UserMapper userMapper;
	@Test
	public void testgetlist() {
		
		List<User> listUser=new ArrayList<>();
		try {
			listUser = userMapper.getListUser();
			System.out.println(listUser.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("执行结束");
		
		
	}

}
