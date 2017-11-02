package com.nisure.model;
/**
* @author xiezhengliang
* @date 2017年10月18日 下午2:04:12
*/
public class SysUser {

	private long user_id;
	private String username;
	private String password;
	private String salt;
	private String email;
	private String mobile;
	private String status;
	private long dept_id;
	private String create_time;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getDept_id() {
		return dept_id;
	}
	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "SysUser [user_id=" + user_id + ", user_name=" + username + ", password=" + password + ", salt=" + salt
				+ ", email=" + email + ", mobile=" + mobile + ", status=" + status + ", dept_id=" + dept_id
				+ ", create_time=" + create_time + "]";
	}
	
}
