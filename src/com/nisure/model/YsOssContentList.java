package com.nisure.model;

import java.util.Date;

/**
* @author xiezhengliang
* @date 2017年10月25日 下午4:17:00
*/
public class YsOssContentList {

	private int id;
	private String url;
	private String productType;
	private String keyword;
	private Date createTime;
	private int ysOssContentId;
	
	private String fileName;
	private String linkUrl;
	private String identify;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getYsOssContentId() {
		return ysOssContentId;
	}
	public void setYsOssContentId(int ysOssContentId) {
		this.ysOssContentId = ysOssContentId;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	@Override
	public String toString() {
		return "YsOssContentListEntity [id=" + id + ", url=" + url + ", productType=" + productType + ", keyword="
				+ keyword + ", createTime=" + createTime + ", ysOssContentId=" + ysOssContentId + ", fileName="
				+ fileName + ", linkUrl=" + linkUrl + ", identify=" + identify + "]";
	}
	
}
