package com.nisure.dao;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.nisure.model.RequestData;
import com.nisure.model.TimingRankingEntity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaiduEngineService {

	private CloseableHttpClient httpClient = HttpClients.createDefault();
	
	public Document documentProvider(RequestData request, int i) {
		int pageSize = request.getEnginconfig().getPage_size();
		String userAgent = request.getUserAgent();
		int startPage = request.getStartPage();
		String url = null;
		try {
			url = request.getEnginconfig().getEngine_base_url() + URLEncoder.encode(request.getKeywords().trim(), "UTF-8")
					+ "&rn=" + pageSize + "&pn=" + ((i + startPage - 2) * pageSize);
		} catch (UnsupportedEncodingException e) {
		}
		HttpGet httpGet = new HttpGet(url); // 创建httpget实例
		httpGet.setHeader("User-Agent", userAgent); // 设置请求头消息User-Agent
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);// 执行http get请求
		} catch (IOException e) {
		}
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			HttpEntity entity = response.getEntity();
			String string = null;
			try {
				string = EntityUtils.toString(entity, "utf-8");
			} catch (ParseException | IOException e) {
			}
			if (string != null) {
				Document doc = Jsoup.parse(string);
				return doc;
			}
		}
		return null;
	}

	public TimingRankingEntity extract(RequestData request) {
		int total = getSearchResultCount(request);
		if (total < 1) {
			return null;
		}
		// 查询的总条数
		int totalNumber = request.getTotalNumber();
		// 每页条数
		int pageSize = request.getEnginconfig().getPage_size();
		Boolean state = true;
		for (int i = 1; i <= (Math.ceil((float) totalNumber / (float) pageSize))
				&& i <= (Math.ceil((float) total / (float) pageSize)) && state; i++) {
			Document document = documentProvider(request, i);
			Elements select = document.select(".c-showurl");
			int size = select.size();
			if (size > 0) {
				for (int j = 1; j <= size; j++) {
					try {
						String showUrl = select.get(j - 1).text();
//						System.out.println("第" + i + "页第" + j + "条");
						if (showUrl != null && !showUrl.isEmpty()) {
//							String[] split = showUrl.split("...");
							String subUrl = showUrl.replace("...", "");
							List<String> linkUrlList = request.getLinkUrlList();
							String trimSubUrl = subUrl.substring(0, subUrl.length()-1);
							String trim = trimSubUrl.trim();
							for (String linkUr : linkUrlList) {
								if (linkUr.contains(trim)) {
									String hrefUrl = select.get(j - 1).attr("href");
									Document childDocument = Jsoup.connect(hrefUrl).get();
									String html = childDocument.html();
									System.out.println("++++++++=======+++++++");
//									===如果有排名，存入数据库===
									if (html.contains(request.getIdentyCode())) {
										System.out.println("存在排名");
//										System.out.println("保存到数据库");
										String baseUri = childDocument.baseUri();
										TimingRankingEntity tre = new TimingRankingEntity();
										tre.setEngineName("baidu");
										tre.setKeyword(request.getKeywords());
										tre.setContentListId(request.getContentListId());
										tre.setSearchTime(new Date());
										tre.setSite(pageSize*(i-1)+j);
										tre.setTotalNum(total);
										tre.setUrl(baseUri);
//										treList.add(tre);
										state = false;
										return tre;
									}
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;

	}
	/**
	 * 获取百度搜索结果数 获取如下文本并解析数字： 百度为您找到相关结果约13,200个
	 * 
	 * @param document
	 *            文档
	 * @return 结果数
	 */
	public int getSearchResultCount(RequestData request) {
		Document document = this.documentProvider(request, 1);
		if (document != null) {
			Elements select = document.select(request.getEnginconfig().getResult_count_element());
			Element totalElement = null;
			if (select.size() <= 0) {
				return 0;
			}
			totalElement = select.first();
			String totalText = totalElement.text();
			String regEx = "[^0-9]";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(totalText);
			totalText = matcher.replaceAll("");
			int total = Integer.parseInt(totalText);
			return total;
		}
		return 0;
	}
	
//	public YsCollectListEntity collect_extract(RequestData request, YsCollectListEntity collectListEntity) {
//		
//		YsCollectListEntity baiducollectListEntity = collectListEntity;
//		// 获取百度搜索结果数
//		int total = getSearchResultCount(request);
//		baiducollectListEntity.setKeyword(request.getKeywords());
//		baiducollectListEntity.setCollectTotal(total);
//		if (total < 1) {
//			return baiducollectListEntity;
//		}
//		// 查询的总条数
//		int totalNumber = request.getTotalNumber();
//		// 每页条数
//		int pageSize = request.getEnginconfig().getPageSize();
//
//		for (int i = 1; i <= (Math.ceil((float)totalNumber / pageSize)) && i <= (Math.ceil((float)total / pageSize)) ; i++) {
//			Document document = this.documentProvider(request, i);
//			// 得到每个title和url的h3标签
//			Elements h3List = document.select("div#content_left div.c-container h3.t");
//			if(h3List!=null){
//				int size = h3List.size();
//				if (size > 0) {
//					for (int j = 1; j <= size; j++) {
//						long startParse = System.currentTimeMillis();
//						Elements aElement = h3List.get(j - 1).select("a");
//						if (aElement.size() > 0) {
//							String url = aElement.get(0).attr("href");
//							String title = aElement.get(0).text();
//							//根据百度url获取网页真实的url地址
//							try {
//								Connection.Response res = Jsoup.connect(url).timeout(6000).method(Connection.Method.GET).followRedirects(false).execute();
//								
//								if(res.header("Location").indexOf("content")>-1){
//									baiducollectListEntity.setCtpage(baiducollectListEntity.getCtpage()+1);									
//							}  
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}  
//                              //这两条语句也可以查询真实url
//								//Document doc=Jsoup.connect(url).timeout(5000).get();						
//								//doc.baseUri()或者doc.location();
//
//							int[] site = { i + request.getStartPage() - 1, j };
//							long endParse = System.currentTimeMillis();
//							baiducollectListEntity.setWebpage(baiducollectListEntity.getCollectTotal()-baiducollectListEntity.getCtpage());
//						}
//					}
//				}
//			}
//		}
//		return baiducollectListEntity;
//	}

}
