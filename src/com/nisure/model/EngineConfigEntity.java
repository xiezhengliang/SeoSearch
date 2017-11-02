package com.nisure.model;
/**
* @author xiezhengliang
* @date 2017年8月16日 上午10:40:50
*/
public class EngineConfigEntity {
	//自增主键
	public int id;
	//搜索引擎名
	public String engine_name;
	//引擎主url
	public String engine_base_url;
	//每页条数
	public int page_size;
	//模拟浏览器的user_agent
	public String user_agent;
	//模拟浏览器的cookie
	public String cookie;
	//h3元素
	public String h3_element;
	//搜索结果的元素
	public String result_count_element;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEngine_name() {
		return engine_name;
	}
	public void setEngine_name(String engine_name) {
		this.engine_name = engine_name;
	}
	public String getEngine_base_url() {
		return engine_base_url;
	}
	public void setEngine_base_url(String engine_base_url) {
		this.engine_base_url = engine_base_url;
	}
	public int getPage_size() {
		return page_size;
	}
	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getH3_element() {
		return h3_element;
	}
	public void setH3_element(String h3_element) {
		this.h3_element = h3_element;
	}
	public String getResult_count_element() {
		return result_count_element;
	}
	public void setResult_count_element(String result_count_element) {
		this.result_count_element = result_count_element;
	}
	@Override
	public String toString() {
		return "EngineConfigEntity [id=" + id + ", engine_name=" + engine_name + ", engine_base_url=" + engine_base_url
				+ ", page_size=" + page_size + ", user_agent=" + user_agent + ", cookie=" + cookie + ", h3_element="
				+ h3_element + ", result_count_element=" + result_count_element + "]";
	}
	
}
