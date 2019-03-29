package com.sy.connect.util.configration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoClientFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2019年3月28日 下午2:20:54
 * @version
 */
@Configuration
public class MongoDataSourceConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.uri}")
	private String mongo_uri;

	@Bean("mongoTransaction")
	public MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
		return new MongoTransactionManager(dbFactory);
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(new MongoClientURI(mongo_uri));
	}

	@Override
	protected String getDatabaseName() {
		return "test";
	}
}
