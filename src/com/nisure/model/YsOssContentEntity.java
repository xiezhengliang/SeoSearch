package com.nisure.model;

import java.io.Serializable;
import java.util.Date;

/**
* @author xiezhengliang
* @date 2017年10月25日 下午3:24:19
*/
public class YsOssContentEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date create_date;
	private String operator_name;
	private Long operator_id;
	private String url;
	private String product_type;
	private Long ysOss_id;
	private String md5;
	private String link_url;
	private int content_serial;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getOperator_name() {
		return operator_name;
	}
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}
	public Long getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(Long operator_id) {
		this.operator_id = operator_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public Long getYsOss_id() {
		return ysOss_id;
	}
	public void setYsOss_id(Long ysOss_id) {
		this.ysOss_id = ysOss_id;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public int getContent_serial() {
		return content_serial;
	}
	public void setContent_serial(int content_serial) {
		this.content_serial = content_serial;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "YsOssContentEntity [id=" + id + ", create_date=" + create_date + ", operator_name=" + operator_name
				+ ", operator_id=" + operator_id + ", url=" + url + ", product_type=" + product_type + ", ysOss_id="
				+ ysOss_id + ", md5=" + md5 + ", link_url=" + link_url + ", content_serial=" + content_serial + "]";
	}
	
	
}
