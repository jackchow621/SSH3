package com.ghost.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghost.dao.UserDao;
import com.ghost.domain.Tuser;
import com.ghost.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	@Override
	public void test() {
		System.out.println("=======UserServiceImpl===========");
	}

	@Override
	public Serializable save(Tuser tuser) {
		return userDao.save(tuser);
	}

	@Override
	public Tuser login(String name, String pwd) {
		Map<String , Object> map = new HashMap<String, Object>();
		String hql = "from Tuser t where t.name=:name and t.pwd=:pwd";
		map.put("name", name);
		map.put("pwd", pwd);
		List<Tuser> usersList = userDao.find(hql, map); 
		if(usersList != null && usersList.size()>0){
			return usersList.get(0);
		}
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
