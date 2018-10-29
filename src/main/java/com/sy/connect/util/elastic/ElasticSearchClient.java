package com.sy.connect.util.elastic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月23日 上午9:45:15
 * @version
 */
@Component
public class ElasticSearchClient {

	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(ElasticSearchClient.class);

	@Value("${spring.elastic.host}")
	private String host;

	@Value("${spring.elastic.port}")
	private int port;

	public TransportClient getClient() {
		TransportClient client = null;
		try {
			client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(host), port));
		} catch (UnknownHostException e) {
			logger.error("获得elasticsearch连接失败,原因：{}", e);
		}
		return client;
	}

	public void close(TransportClient client) {
		if (client != null) {
			client.close();
		}
	}
}
