package com.zxxz.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxxz.common.BaseController;
import com.zxxz.entity.User;
import com.zxxz.service.UserService;
import com.zxxz.utils.SecurityUtils;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "login",produces = "text/html;charset=UTF-8")
	public String userLogin(HttpServletRequest request, HttpServletResponse response){
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		if(StringUtils.isBlank(userName)||StringUtils.isBlank(passWord)){
			return "redirect:/login.jsp";
		}
		passWord = SecurityUtils.string2MD5(passWord);
		Map<String, Object> loginCheck = userService.loginCheck(userName, passWord);
		if((Boolean)loginCheck.get("flag")){
			request.setAttribute("currentUser", loginCheck.get("currentUser"));
			return "index";
		}
		return "redirect:/login.jsp";
	}
	
	@RequestMapping(value = "login1",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		user.setAge(55);
		user.setId(3);
		user.setUserName("zxxz");
		user.setPassword("123");
		
		try {
			objSetAttribute(request, user, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}
