package com.sy.connect.util.qsl.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sy.connect.util.qsl.mongo.domain.User;
import com.sy.connect.util.qsl.mongo.repository.UserRepository;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2019年3月28日 下午1:39:02
 * @version
 */
@Service("userMongoService")
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Transactional(value = "mongoTransaction")
	public void testTransaction() {
		User user = new User();
		user.setEmail("11@126.com");
		user.setFirstname("n");
		user.setLastname("k");
		user.setNationality("23");
		user.setPassword("aaa");
		user.setUsername("nk4");
		userRepository.save(user);
		user.setUsername("nk5");
		System.out.println(1 / 0);
		userRepository.save(user);
		System.out.println(1 / 0);
	}

}
