package com.rong.ssi.login.daoImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.rong.ssi.login.dao.UserDao;
import com.rong.ssi.login.entity.User;

/**
 * @author »›≈‡Ìµ
 * ”√ªßµ«¬ΩDao
 * 
 */
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao{

	@Override
	public boolean insertUser(User user) {
		try {
			getSqlMapClientTemplate().insert("insertUser",user);
			return true;
		} catch (Exception e) {
            e.printStackTrace();
			return false;
		}
	}

	@Override
	public User queryByName(String name) {
		try {
			User user=(User) getSqlMapClientTemplate().queryForObject("selsectUser",name);
			return user; 
		} catch (Exception e) {
            e.printStackTrace();
			return null;
		}
	}



	@Override
	public List<User> queryUserList(Map<String, Object> map) {

		List<User> list=new ArrayList<User>();
		try {
			list=getSqlMapClient().queryForList("queryUser",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer queryUserListTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			return (Integer) getSqlMapClient().queryForObject("queryUserListTotal",map);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteUser(Map<String, Object> map) {
		try {
			getSqlMapClient().delete("deleteUser",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public Integer queryRoleDaoListTotal(Map<String, Object> map){
    	try {
			return (Integer) getSqlMapClient().queryForObject("queryRoleDaoListTotal",map);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }


    
}
