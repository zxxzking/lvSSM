package com.zxxz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxxz.dao.UserDao;
import com.zxxz.entity.User;
import com.zxxz.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource  
	private UserDao userDao;  
	@Override    
	public User getUserById(int userId) {  
	        // TODO Auto-generated method stub  
	    return this.userDao.selectByPrimaryKey(userId);  
	}
	@Override
	public int addUser(){
		User user = new User();
		user.setAge(15);
		user.setUserName("zzxa");
		user.setPassword("a12345");
		return userDao.insert(user);
	}
	
}
