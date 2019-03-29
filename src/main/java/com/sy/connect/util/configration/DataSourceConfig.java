package com.sy.connect.util.configration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/3/26 下午9:11.
 * @blog http://blog.didispace.com
 */
@Configuration
public class DataSourceConfig {

	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix = "spring.data.mysql.primary")
	public DataSource primaryDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "secondaryDataSource")
	@Qualifier("secondaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.data.mysql.secondary")
	public DataSource secondaryDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

}
