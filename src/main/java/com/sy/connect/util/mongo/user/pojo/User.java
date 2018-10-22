/**
 * Copyright (c) 2006-2015 Kingdee Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Kingdee. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Kingdee,http://www.Kingdee.com.
 *  
 */
package com.sy.connect.util.mongo.user.pojo;

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
public class User {

	private Long id;

	private String userName;

	private String nickName;

	private int age;
}
