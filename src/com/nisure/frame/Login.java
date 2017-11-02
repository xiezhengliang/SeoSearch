package com.nisure.frame;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.crypto.hash.Sha256Hash;

import com.nisure.model.EngineConfigEntity;
import com.nisure.model.SysUser;
import com.nisure.model.UserAgentEntity;
import com.nisure.model.YsOssContentEntity;
import com.nisure.model.YsOssContentList;
import com.nisure.model.YsOssPathEntity;
import com.nisure.test.Test;

/**
 * @author xiezhengliang
 * @date 2017年10月18日 下午2:49:21
 */
public class Login {
	static String RESOURCE = "conf.xml";

	public SysUser userLogin(String userName, String password) {
		InputStream is = Test.class.getClassLoader().getResourceAsStream(RESOURCE);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.nisure.mapper.sysUser.getSysUser";// 映射sql的标识字符串
		// 用户信息
		SysUser user = session.selectOne(statement, "admin");
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.close();
		return user;
	}

	public List<YsOssContentEntity> getYsOssContentById(long operatorId) {
		InputStream is = Test.class.getClassLoader().getResourceAsStream(RESOURCE);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.nisure.mapper.ysOssContent.getYsOssContentById";// 映射sql的标识字符串
		List<YsOssContentEntity> result = session.selectList(statement, 18L);
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.close();
		return result;
	}

	public List<YsOssContentList> getYsOssContentListByIds(List<Long> ysOssContentIds) {
		InputStream is = Test.class.getClassLoader().getResourceAsStream(RESOURCE);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.nisure.mapper.ysOssContentList.getYsOssContentLIstByIds";// 映射sql的标识字符串
		HashMap<String, Object> parames = new HashMap<String, Object>();
		parames.put("mapList", ysOssContentIds);
		List<YsOssContentList> selectList = session.selectList(statement, parames);
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.close();
		return selectList;
	}
	
	public List<YsOssPathEntity> queryYsOssPathList(java.util.List<YsOssContentList> yb){
		InputStream is = Test.class.getClassLoader().getResourceAsStream(RESOURCE);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.nisure.mapper.ysOssPath.queryList";// 映射sql的标识字符串
		HashMap<String, Object> parames = new HashMap<String, Object>();
		parames.put("mapList", "");
		List<YsOssPathEntity> selectList = session.selectList(statement, parames);
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.close();
		return selectList;
	}
	
	public EngineConfigEntity getEngineConfig(String engine){
		InputStream is = Test.class.getClassLoader().getResourceAsStream(RESOURCE);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.nisure.mapper.engineConfig.getEngineConfig";// 映射sql的标识字符串
		EngineConfigEntity ece = session.selectOne(statement,"baidu");
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.close();
		return ece;	
	}
	
	public UserAgentEntity getUserAgentRandom(){
		InputStream is = Test.class.getClassLoader().getResourceAsStream(RESOURCE);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.nisure.mapper.userAgent.getUserAgent";// 映射sql的标识字符串
		UserAgentEntity uae = session.selectOne(statement,"");
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.close();
		return uae;
	}
}
