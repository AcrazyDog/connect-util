package com.sy.connect.util.mysql.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.sy.connect.util.Application;
import com.sy.connect.util.domain.User;
import com.sy.connect.util.mysql.datasource1.UserRepository1;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2019年3月25日 下午2:24:53
 * @version
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootApplication
public class MysqlServiceTest {

	@Autowired
	private UserRepository1 userRepository1;

	@Autowired
	private com.sy.connect.util.mysql.datasource2.UserRepository2 userRepository2;

	@Test
	public void testMulDataSource() {
		User user = new User();
		// user.setId(1L);
		user.setAge(1);
		user.setNickName("1");
		user.setUserName("1");
		userRepository1.save(user);

		System.out.println(JSONObject.toJSONString(userRepository1.findAll()));

		user.setAge(2);
		user.setNickName("2");
		user.setUserName("2");
		userRepository2.save(user);

		System.out.println(JSONObject.toJSONString(userRepository2.findAll()));

	}

}
