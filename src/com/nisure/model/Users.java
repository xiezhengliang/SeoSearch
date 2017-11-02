package com.nisure.model;
/**
* @author xiezhengliang
* @date 2017年10月17日 下午5:55:23
*/
public class Users {

	private int id;
	private String user_name;
	private String pass_word;
	private String nick_name;
	private String user_sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", user_name=" + user_name + ", pass_word=" + pass_word + ", nick_name=" + nick_name
				+ ", user_sex=" + user_sex + "]";
	}
	
	
	
}
