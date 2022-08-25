package com.learnwell.poc.vo;

import java.util.List;

public class QueryRequest {
	List<QueryValueMap> queryValueMap;
	String endQuery;
	long count;
	
	public List<QueryValueMap> getQueryValueMap() {
		return queryValueMap;
	}
	public void setQueryValueMap(List<QueryValueMap> queryValueMap) {
		this.queryValueMap = queryValueMap;
	}
	public String getEndQuery() {
		return endQuery;
	}
	public void setEndQuery(String endQuery) {
		this.endQuery = endQuery;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
}
