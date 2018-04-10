package com.rong.ssi.quartz.service;


import java.util.List;
import java.util.Map;


public interface CommonServiceInter {
  
	 public <T> T queryObject(String str,T o);
	 public    <T> List<T> queryObjectList(String str,Map<String, Object> o);
	 public Integer queryObjectListTotal(String str,Map<String, Object> map);

}
