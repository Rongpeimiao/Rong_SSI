package com.rong.ssi.quartz.dao;


import java.util.List;
import java.util.Map;

/**      
 * @author �����      
 * quartz����dao�� �ӿ�  
 */ 
public interface CommonDaoInter {
   
	 public <T> T queryObject(String str,T t);
	 public  <T> List<T> queryObjectList(String str,Map<String ,Object> o);
	 public Integer queryObjectListTotal(String str,Map<String, Object> map);
}
