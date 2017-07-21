package com.zxxz.dao;

import com.zxxz.entity.User;

public interface UserDao {
	 int deleteByPrimaryKey(Integer id);

	 int insert(User record);

	 int insertSelective(User record);

	 User selectByPrimaryKey(Integer id);

	 int updateByPrimaryKeySelective(User record);

	 int updateByPrimaryKey(User record);
	 
	 User selectByName(String userName);
}
