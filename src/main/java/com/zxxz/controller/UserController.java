package com.zxxz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxxz.utils.RSA;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "login",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String userLogin(HttpServletRequest request, HttpServletResponse response){
		
		String passWord = request.getParameter("passWord");
		try {
			passWord = RSA.encryptByPublicKey(passWord);
			
			logger.info(passWord);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passWord;
	}
}
