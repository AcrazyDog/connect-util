package com.sy.connect.util.mongo.repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月12日 上午10:02:24
 * @version
 */
public interface MongoRepository<T> {

	public void save(T t);

	public List<T> findAll(Class<T> c);

	public void updateById(T t);

	public void updateByParams(Map<String, Object> params, T t);

	public T findOne(Map<String, Object> params, Class<T> c);

	public List<T> findByParams(Map<String, Object> params, Class<T> c);
}
