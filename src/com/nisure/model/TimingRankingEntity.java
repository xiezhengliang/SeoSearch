package com.nisure.model;

import java.util.Date;

/**
* @author xiezhengliang
* @date 2017年9月4日 上午10:22:08
*/
public class TimingRankingEntity {

	private long id;
	private int contentListId;
	private String keyword;
	private Date searchTime;
	private String url;
	private int site;
	private long totalNum;
	private String engineName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getContentListId() {
		return contentListId;
	}
	public void setContentListId(int contentListId) {
		this.contentListId = contentListId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(Date searchTime) {
		this.searchTime = searchTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSite() {
		return site;
	}
	public void setSite(int site) {
		this.site = site;
	}
	public long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}
	public String getEngineName() {
		return engineName;
	}
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}
	@Override
	public String toString() {
		return "TimingRankingEntity [id=" + id + ", contentListId=" + contentListId + ", keyword=" + keyword
				+ ", searchTime=" + searchTime + ", url=" + url + ", site=" + site + ", totalNum=" + totalNum
				+ ", engineName=" + engineName + "]";
	}

}
