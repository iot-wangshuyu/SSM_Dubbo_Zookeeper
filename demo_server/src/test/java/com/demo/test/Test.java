package com.demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shuyu.redis.cluster.RedisCluster;


public class Test {
	
	public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-redis.xml");
        context.start();
        RedisCluster redisCluster= (RedisCluster) context.getBean("redisCluster");
       
        Object object = redisCluster.get("1");
        System.out.println(object);
    }

}
