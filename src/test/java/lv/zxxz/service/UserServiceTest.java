package lv.zxxz.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zxxz.entity.User;
import com.zxxz.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:dataSource.xml","classpath:servlet-context.xml"}) 
public class UserServiceTest {
	private static Logger logger = Logger.getLogger(UserServiceTest.class);  
	@Resource  
	private UserService userService; 
	 
	@Test  
	public void test1() {  
	   User user = userService.getUserById(5);  
	   // System.out.println(user.getUserName());  
	   // logger.info("值："+user.getUserName());  
	   logger.info(JSON.toJSONString(user));  
	}
	
	@Test
	public void test2(){
		int addUser = userService.addUser();
		System.out.println(addUser);
	}
	
}
