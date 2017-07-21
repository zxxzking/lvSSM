package com.zxxz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxxz.common.BaseController;
@Controller
@RequestMapping(value = "/kAdmin")
public class AdminController extends BaseController{
	@RequestMapping(value = "/dark", produces = "text/html;charset=UTF-8")
	public String redDark(HttpServletRequest request, HttpServletResponse response){
		return "KAdmin-Dark/index";
	}
	@RequestMapping(value = "/light", produces = "text/html;charset=UTF-8")
	public String redLight(HttpServletRequest request, HttpServletResponse response){
		return "KAdmin-Light/index";
	}
}
