package com.sy.connect.util.elastic.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sy.connect.util.Application;
import com.sy.connect.util.elastic.ElasticSearchClient;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月29日 上午9:04:52
 * @version
 */
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ElasticSearchTest {

	@Autowired
	private ElasticSearchClient elasticSearchClient;

	@Test
	public void testGetClient() {
		elasticSearchClient.getClient();
	}
}
