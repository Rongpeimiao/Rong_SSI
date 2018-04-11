package com.rong.ssi.login.serviceImpl;


import java.util.List;
import java.util.Map;

import com.rong.ssi.login.dao.UserDao;
import com.rong.ssi.login.entity.User;
import com.rong.ssi.login.service.UserDaoServiceInter;
/**      
 * 用户注册服务      
 * @author 容培淼      
 * @return      
 */ 
public class UserDaoServiceImpl implements UserDaoServiceInter{

	private UserDao userdao;
	
	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public boolean insertUser(User user) {
		return userdao.insertUser(user);
	}

	@Override
	public User querybyname(String name) {
		return userdao.queryByName(name);
	}
	@Override
	public List<User> queryUserList(Map<String, Object> map) {
		return userdao.queryUserList(map);
	}

	@Override
	public Integer queryUserListTotal(Map<String, Object> map) {
		return userdao.queryUserListTotal(map);
	}

	@Override
	public void deleteUser(Map<String, Object> map) {
		userdao.deleteUser(map);
	}

}
