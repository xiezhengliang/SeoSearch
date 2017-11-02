package com.nisure.model;

import java.util.ArrayList;
import java.util.List;


/**
 * 要查找的条件
 * @author xiezhengliang
 * @date 2017年8月12日 上午9:30:02
 */
public class RequestData {
		//初始化开始页数为1
//		private int INITSTARTPAGE=1;
		private BaseEngine engineName;
		/*
		 * 关键词
		 */
        private String keywords ;
        
        /*
         * content_list_id
         */
        
        private int contentListId;
        
        /*
         * 一共要查的页数
         */
        private int  totalNumber;
        
        /*
         * 开始页数
         */
        private int startPage;
        
        /*
         * 识别码
         */
        private String identyCode;
        
        /*
         * 配置初始化信息
         */
        private EngineConfigEntity enginconfig;
        
        /*
         * userAgent
         */
        private String userAgent;
        
        private List<String> linkUrlList;

		public BaseEngine getEngineName() {
			return engineName;
		}

		public void setEngineName(BaseEngine engineName) {
			this.engineName = engineName;
		}

		public String getKeywords() {
			return keywords;
		}

		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}

		public int getTotalNumber() {
			return totalNumber;
		}

		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}

		public int getStartPage() {
			return startPage;
		}

		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}

		public String getIdentyCode() {
			return identyCode;
		}

		public void setIdentyCode(String identyCode) {
			this.identyCode = identyCode;
		}

		public EngineConfigEntity getEnginconfig() {
			return enginconfig;
		}

		public void setEnginconfig(EngineConfigEntity enginconfig) {
			this.enginconfig = enginconfig;
		}

		public String getUserAgent() {
			return userAgent;
		}

		public void setUserAgent(String userAgent) {
			this.userAgent = userAgent;
		}

		public List<String> getLinkUrlList() {
			return linkUrlList;
		}

		public void setLinkUrlList(List<String> linkUrlList) {
			this.linkUrlList = linkUrlList;
		}
		
		

		public int getContentListId() {
			return contentListId;
		}

		public void setContentListId(int contentListId) {
			this.contentListId = contentListId;
		}

		@Override
		public String toString() {
			return "RequestData [engineName=" + engineName + ", keywords=" + keywords + ", contentListId="
					+ contentListId + ", totalNumber=" + totalNumber + ", startPage=" + startPage + ", identyCode="
					+ identyCode + ", enginconfig=" + enginconfig + ", userAgent=" + userAgent + ", linkUrlList="
					+ linkUrlList + "]";
		}

	
	
}
