package com.rong.ssi.login.service;


import java.util.List;
import java.util.Map;

import com.rong.ssi.login.entity.User;


public interface UserDaoServiceInter {
	/**      
	 * �û�ע�����ӿ�      
	 * @author �����      
	 * @return      
     */         
	 public boolean insertUser(User user);   
	 public User querybyname(String name);  
	 public List<User>  queryUserList(Map<String, Object> map);
	 public Integer queryUserListTotal(Map<String, Object> map);
	 public void deleteUser(Map<String, Object> map);

}
