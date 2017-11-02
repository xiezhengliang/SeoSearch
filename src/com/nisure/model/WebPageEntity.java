package com.nisure.model;

import java.util.Arrays;

/**
 * 返回的结果类
 * 
* @author xiezhengliang
* @date 2017年8月11日 下午4:09:53
*/
public class WebPageEntity {
	//搜索引擎名
	private String engineName;
	//标题
	private String title;
	//搜索出来的总条数
	private int total;
	//搜索用的时间
	private long searchTime;
	//解析用的时间
	private long parseTime;
	//url
	private String url;
	//是否存在
	private boolean isExist;
	//位置
	private int[] site;
	//排位
	private Integer rank;
	//关键词
	private String keyword;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int[] getSite() {
		return site;
	}
	public void setSite(int[] site) {
		this.site = site;
	}
	public boolean isExist(boolean isExist) {
		return isExist;
	}
	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public long getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(long searchTime) {
		this.searchTime = searchTime;
	}
	public long getParseTime() {
		return parseTime;
	}
	public void setParseTime(long parseTime) {
		this.parseTime = parseTime;
	}
	public boolean isExist() {
		return isExist;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getEngineName() {
		return engineName;
	}
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}
	@Override
	public String toString() {
		return "WebPageEntity [engineName=" + engineName + ", title=" + title + ", total=" + total + ", searchTime="
				+ searchTime + ", parseTime=" + parseTime + ", url=" + url + ", isExist=" + isExist + ", site="
				+ Arrays.toString(site) + ", rank=" + rank + ", keyword=" + keyword + "]";
	}
	
}
