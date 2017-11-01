package com.demo.mapper;

import java.util.List;


import com.demo.pojo.User;

/**
 * @ClassName: UserMapper 
 * @Description: TODO
 * @author shuyu.wang
 * @date 2017年10月31日 下午5:10:58 
 * @version V1.0
 */
public interface UserMapper {
	
	List<User> getListUser() throws Exception;

}
