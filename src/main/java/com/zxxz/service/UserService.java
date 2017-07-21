package com.zxxz.service;

import java.util.Map;

import com.zxxz.entity.User;

public interface UserService {
	public User getUserById(int userId);

	int addUser();
	/**
	 * 登录验证
	 * @param userName
	 * @param passWord
	 * @return
	 */
	Map<String, Object> loginCheck(String userName, String passWord); 
}
