package com.nisure.model;

import org.jsoup.nodes.Document;



/**
 * 搜索引擎 接口
 * 所有搜索引擎都要实现此方法
 *@author xiezhengliang  
 *@date 2017年8月11日 上午9:40:28
 */
public interface BaseEngine {
        /**
         * url
         */
//        Document buildDocument(RequestData request,int currentPage) throws Exception;

//        /**
//         *连接方式
//         */
//        Method method();
//
//        /**
//         *user agent
//         */
//        String UA();
//        /**
//         * cookie
//         * @return
//         */
//        String cookie();
        /**
         * 能搜索到的提取出来的页面信息
         */
        WebPageEntity extract(RequestData request) throws Exception;
        /**
         * 提供document
         * @param url
         * @return
         */
        Document documentProvider(RequestData request, int currentPage);
        
        int getSearchResultCount(RequestData request);
        
//        Document getChildDocument(RequestData request,String url);
}
