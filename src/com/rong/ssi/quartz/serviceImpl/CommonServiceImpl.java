package com.rong.ssi.quartz.serviceImpl;


import java.util.List;
import java.util.Map;

import com.rong.ssi.quartz.dao.CommonDaoInter;
import com.rong.ssi.quartz.service.CommonServiceInter;
/**      
 * @author 容培淼      
 * quartz公共服务类   
 */ 
public class CommonServiceImpl implements CommonServiceInter {

	 private CommonDaoInter commonDaoInter;
	 
	 
	public CommonDaoInter getCommonDaoInter() {
		return commonDaoInter;
	}

	public void setCommonDaoInter(CommonDaoInter commonDaoInter) {
		this.commonDaoInter = commonDaoInter;
	}

	@Override
	public <T> T queryObject(String str,  T o) {
		return commonDaoInter.queryObject(str, o);
	}

	@Override
	public   <T> List<T> queryObjectList(String str, Map<String ,Object> o) {
		return commonDaoInter.queryObjectList(str, o);
	}

	@Override
	public Integer queryObjectListTotal(String str, Map<String, Object> map) {
		return commonDaoInter.queryObjectListTotal(str, map);
	}

}
