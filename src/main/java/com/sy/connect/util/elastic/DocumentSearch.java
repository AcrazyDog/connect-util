package com.sy.connect.util.elastic;

import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;

import com.sy.connect.util.elastic.param.SearchParam;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Administrator
 * @date 2018年10月22日 下午2:45:33
 * @version
 */
public interface DocumentSearch {

	public SearchResponse searchDocument(SearchParam searchParam);

	public void addDocument(String index, Object obj);

	public void updateDocument(String index, Object obj, Map<String, Object> queryParams);
}
