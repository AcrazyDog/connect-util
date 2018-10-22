package com.sy.connect.util.mongo.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.connect.util.mongo.repository.MongoRepository;
import com.sy.connect.util.mongo.user.pojo.User;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月15日 下午5:44:01
 * @version
 */
@Service
public class UserService {

	@Autowired
	private MongoRepository<User> mongoRepository;

	public void saveUser(User user) {
		mongoRepository.save(user);
	}

	public List<User> findAllUsers() {
		return mongoRepository.findAll(User.class);
	}

	public User findById(Long id) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put("id", id);
		return mongoRepository.findOne(map, User.class);
	}

	public void updateUser(User user) {
		mongoRepository.updateById(user);
	}
}
