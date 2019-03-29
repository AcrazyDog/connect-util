package com.sy.connect.util.qsl.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.types.Predicate;
import com.sy.connect.util.Application;
import com.sy.connect.util.mongo.user.service.UserService;
import com.sy.connect.util.qsl.mongo.domain.QUser;
import com.sy.connect.util.qsl.mongo.domain.User;
import com.sy.connect.util.qsl.mongo.repository.UserRepository;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2019年3月28日 上午10:21:27
 * @version
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootApplication
public class QslTest {

	@Resource
	private UserRepository userRepository;

	@Resource(name = "userMongoService")
	private com.sy.connect.util.qsl.mongo.service.UserService userService;

	@Test
	public void testMongoQsl() {
		User user = new User();
		user.setEmail("11@126.com");
		user.setFirstname("n");
		user.setLastname("k");
		user.setNationality("23");
		user.setPassword("aaa");
		user.setUsername("nk1");
		userRepository.save(new User());

		QUser qUser = new QUser("user");
		Predicate predicate = qUser.username.eq("nk1");
		List<User> users = (List<User>) userRepository.findAll(predicate);

		System.out.println(JSONObject.toJSONString(users));
	}

	@Test
	public void testTransaction() {
		QUser qUser = new QUser("user");
		Predicate predicate = qUser.username.eq("nk4");
		List<User> users = (List<User>) userRepository.findAll(predicate);

		System.out.println(JSONObject.toJSONString(users));

		userService.testTransaction();
	}

}
