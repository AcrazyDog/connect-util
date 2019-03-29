//package com.sy.connect.util.configration;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//
///**
// * <p>
// * 
// * </p>
// * 
// * @author Administrator
// * @date 2019年3月25日 下午1:52:04
// * @version
// */
//@Configuration
//public class MysqlDataSourceConfig {
//
//	@Bean(name = "primaryDataSource")
//	@Qualifier("primaryDataSource")
//	@ConfigurationProperties(prefix = "spring.data.mysql.primary")
//	public DataSource primaryDataSource() {
//		return DruidDataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "secondaryDataSource")
//	@Qualifier("secondaryDataSource")
//	@Primary
//	@ConfigurationProperties(prefix = "spring.data.mysql.secondary")
//	public DataSource secondaryDataSource() {
//		return DruidDataSourceBuilder.create().build();
//	}
//}
