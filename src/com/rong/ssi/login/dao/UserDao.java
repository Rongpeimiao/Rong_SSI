package com.rong.ssi.login.dao;


import java.util.List;
import java.util.Map;

import com.rong.ssi.login.entity.User;
/**
 * @author 容培淼
 * 用户登陆Dao接口
 * 
 */

public interface  UserDao {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user);
	public User queryByName(String name);
	public List<User>  queryUserList(Map<String, Object> map);
	public Integer queryUserListTotal(Map<String, Object> map);
	public void deleteUser(Map<String, Object> map);
	
}
