/**
 * Copyright (c) 2006-2015 Kingdee Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Kingdee. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Kingdee,http://www.Kingdee.com.
 *  
 */
package com.sy.connect.util.mongo.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.sy.connect.util.Application;
import com.sy.connect.util.mongo.user.pojo.User;
import com.sy.connect.util.mongo.user.service.UserService;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月12日 上午10:47:48
 * @version
 */
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testSaveUser() {

		User user = new User();
		user.setAge(110);
		user.setId(1L);
		user.setUserName("linsan");
		userService.saveUser(user);

		List<User> findAll = userService.findAllUsers();

		System.out.println(JSONObject.toJSONString(findAll));
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setAge(120);
		user.setId(1L);
		user.setUserName("linsan");
		userService.saveUser(user);
		user.setAge(110);
		user.setUserName("qingxuan");

		userService.updateUser(user);

		User findUser = userService.findById(1l);
		System.out.println(JSONObject.toJSONString(findUser));
	}
}
