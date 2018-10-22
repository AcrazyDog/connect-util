package com.sy.connect.util.mongo.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.sy.connect.util.mongo.repository.MongoRepository;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月15日 下午5:35:11
 * @version
 */
@Repository
public class MongoRepositoryImpl<T> implements MongoRepository<T> {

	private static final Logger logger = LoggerFactory.getLogger(MongoRepositoryImpl.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void save(T t) {
		mongoTemplate.save(t);
	}

	@Override
	public List<T> findAll(Class<T> c) {
		return mongoTemplate.findAll(c);
	}

	@Override
	public void updateById(T t) {
		try {
			Method method = t.getClass().getMethod("getId");
			Object id = method.invoke(t);
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(id));
			Update update = new Update();
			setUpdateValue(update, t);
			mongoTemplate.updateFirst(query, update, t.getClass());
		} catch (Exception e) {
			logger.error("mongo updateById error,object is:{}:error Message:{} ", JSONObject.toJSONString(t), e);
		}
	}

	@Override
	public void updateByParams(Map<String, Object> params, T t) {
		try {
			Query query = buildQuery(params);
			Update update = new Update();
			setUpdateValue(update, t);
			mongoTemplate.updateMulti(query, update, t.getClass());
		} catch (Exception e) {
			logger.error("mongo updateById error,object is:{}:error Message:{} ", JSONObject.toJSONString(t), e);
		}
	}

	@Override
	public List<T> findByParams(Map<String, Object> params, Class<T> c) {
		Query query = buildQuery(params);
		return mongoTemplate.find(query, c);
	}

	private Query buildQuery(Map<String, Object> params) {
		Query query = new Query();
		for (Entry<String, Object> entry : params.entrySet()) {
			query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
		}
		return query;
	}

	@Override
	public T findOne(Map<String, Object> params, Class<T> c) {
		List<T> values = findByParams(params, c);
		if (!CollectionUtils.isEmpty(values)) {
			return values.get(0);
		} else {
			return null;
		}
	}

	private void setUpdateValue(Update update, T t) throws Exception {
		Field[] fields = t.getClass().getDeclaredFields();

		for (Field field : fields) {
			String filedName = field.getName();
			Method method = t.getClass().getMethod("get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length()));
			Object filedValue = method.invoke(t);
			if (filedValue != null) {
				update.set(filedName, filedValue);
			}
		}
	}

}
