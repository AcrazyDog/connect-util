/**
 * Copyright (c) 2006-2015 Kingdee Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Kingdee. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Kingdee,http://www.Kingdee.com.
 *  
 */
package com.sy.connect.util.elastic.param;

import java.util.List;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月23日 上午8:31:40
 * @version
 */
@Data
public class SearchParam {

	private String queryStr;

	private List<String> highLightFields;

	private List<String> queryFileds;

	private int size;

	private int from;

	private String index;
}
