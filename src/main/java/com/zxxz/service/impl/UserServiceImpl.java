package com.zxxz.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zxxz.dao.UserDao;
import com.zxxz.entity.User;
import com.zxxz.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String,Object> loginCheck(String userName,String passWord){
		Map map = new HashMap<String, Object>();
		boolean flag = false;
		User user = userDao.selectByName(userName);
		map.put("currentUser", user);
		if(user == null){
			log.info("用户不存在");
			map.put("flag", flag);
			return map;
		}
		if(user.getPassword().equals(passWord)){
			flag = true;
			map.put("flag", flag);
			return map;
		}
		log.info("密码错误");
		map.put("flag", flag);
		return map;
	}
	
}
