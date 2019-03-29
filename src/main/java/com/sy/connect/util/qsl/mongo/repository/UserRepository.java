package com.sy.connect.util.qsl.mongo.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

import com.querydsl.core.types.dsl.StringPath;
import com.sy.connect.util.qsl.mongo.domain.QUser;
import com.sy.connect.util.qsl.mongo.domain.User;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2019年3月28日 上午9:51:52
 * @version
 */
public interface UserRepository extends CrudRepository<User, String>,
		QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.data.querydsl.binding.QuerydslBinderCustomizer#
	 * customize(org.springframework.data.querydsl.binding.QuerydslBindings,
	 * com.mysema.query.types.EntityPath)
	 */
	@Override
	default public void customize(QuerydslBindings bindings, QUser root) {

		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
		bindings.excluding(root.password);
	}
}
