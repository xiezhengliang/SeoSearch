package com.nisure.model;

/**
 * @author xiezhengliang
 * @date 2017年11月1日 上午11:44:43
 */
public class YsOssPathEntity {

	private Long id;
	private String path;
	private String server_name;
	private String link_path;
	private Integer ys_ftp_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public String getLink_path() {
		return link_path;
	}
	public void setLink_path(String link_path) {
		this.link_path = link_path;
	}
	public Integer getYs_ftp_id() {
		return ys_ftp_id;
	}
	public void setYs_ftp_id(Integer ys_ftp_id) {
		this.ys_ftp_id = ys_ftp_id;
	}
	@Override
	public String toString() {
		return "YsOssPathEntity [id=" + id + ", path=" + path + ", server_name=" + server_name + ", link_path="
				+ link_path + ", ys_ftp_id=" + ys_ftp_id + "]";
	}


}
