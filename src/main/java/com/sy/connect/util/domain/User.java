package com.sy.connect.util.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月15日 下午5:44:30
 * @version
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "user_name")
	private String userName;

	@Column(nullable = false, name = "nick_name")
	private String nickName;

	private int age;
}
