package com.sy.connect.util.mysql.datasource1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sy.connect.util.domain.User;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2019年3月25日 下午2:22:14
 * @version
 */
public interface UserRepository1 extends JpaRepository<User, Long> {
	
}
