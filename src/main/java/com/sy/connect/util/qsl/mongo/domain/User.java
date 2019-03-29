package com.sy.connect.util.qsl.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.querydsl.core.annotations.QueryEntity;

import lombok.Data;
import lombok.Value;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2019年3月28日 上午9:53:07
 * @version
 */
@Data
@Document
@QueryEntity
public class User {

	private @Id String username;

	private String firstname, lastname, email, nationality;

	private @JsonIgnore String password;

	private @JsonUnwrapped Address address;

	private Picture picture;

	@Value
	public static class Address {

		String city, street, zip;
	}

	@Value
	public static class Picture {

		String large, medium, small;
	}
}