package com.zxxz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxxz.entity.User;
import com.zxxz.service.UserService;
import com.zxxz.utils.JsonResponse;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService serService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "login",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String userLogin(HttpServletRequest request, HttpServletResponse response){
		User user = serService.getUserById(5);
		Map result = new HashMap<String, Object>();
		JsonResponse jsonResponse = null;
		if(user!=null){
			HttpSession session = request.getSession();
			result.put("user", user);
			result.put("sessionId", session.getId());
			jsonResponse = JsonResponse.buildSuccess("success", result);
			
			System.out.println(session.getId());
			session.setAttribute("user", user);
		}else{
			jsonResponse = JsonResponse.buildFailure("fail");
		}
		return jsonResponse.toJsonString();
	}
}
