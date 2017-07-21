package lv.zxxz.controller;

import javax.annotation.Resource;

import lv.zxxz.common.TestBaseCase;

import org.junit.Test;

import com.zxxz.controller.UserController;

public class UserControllerTest extends TestBaseCase{
	@Resource
	private UserController userController;
	@Test
	public void Test(){
		request.setParameter("passWord", "a1235");
		String res = userController.userLogin(request, response);
		System.out.println(res);
	}
	@Test
	public void Test2(){
		userController.test(request, response);
		
	}
	
	
	
}
