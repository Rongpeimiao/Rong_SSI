package com.rong.ssi.quartz.daoImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.rong.ssi.common.Log4jUtil;
import com.rong.ssi.quartz.dao.CommonDaoInter;


public class CommonDaoImpl extends SqlMapClientDaoSupport implements CommonDaoInter {


	@Override
	public  <T> T queryObject(String str, T o) {
		T object = null   ;
		try {
			object= (T) getSqlMapClient().queryForObject(str,o);
		} catch (SQLException e) {
			Log4jUtil.Log4jUtilThrowable(new Throwable().getStackTrace()[1].getClassName(), e);
		}
		return object;
	}

	@Override
	public <T> List<T> queryObjectList(String str,Map<String, Object> o) {
		List<T> list=new ArrayList<T>();
		try {
			list=(List<T>)getSqlMapClient().queryForList(str, o);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer queryObjectListTotal(String str, Map<String, Object> map) {
		Integer num=0;
		try {
			return num=(Integer) getSqlMapClient().queryForObject(str,map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
