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
	    
	public User getUserById(int userId) {  
	        // TODO Auto-generated method stub  
	    return this.userDao.selectByPrimaryKey(userId);  
	}
	
}
