package com.nisure.model;
/**
* @author xiezhengliang
* @date 2017年8月22日 上午11:53:21
*/
public class UserAgentEntity {

	private int id;
	private String user_agent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	@Override
	public String toString() {
		return "UserAgentEntity [id=" + id + ", user_agent=" + user_agent + "]";
	}
	
	
}
