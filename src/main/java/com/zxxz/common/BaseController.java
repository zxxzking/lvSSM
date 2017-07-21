package com.zxxz.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
/**
 * 
 * <pre>
 * Description
 * Copyright:	Copyright (c) 2017  
 * Company:		
 * Author:		Lv
 * Version:		1.0  
 * Create at:	2017年7月21日 上午10:45:47  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------  
 * 
 * </pre>
 */
@Controller
public class BaseController {
	
	
	@SuppressWarnings("unused")
	public <T> void objSetAttribute(HttpServletRequest request,T obj,Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Map<String,Object> maps = new HashMap<String,Object>();
		T  dataBean = null;
		dataBean = clazz.newInstance();
		Class<? extends Object> cls = obj.getClass();
		Field[] fields1 = clazz.getDeclaredFields();
		Field[] fields2 = cls.getDeclaredFields();
		for (Field field : fields2) {
			String name = field.getName();
			String strGet = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());  
			Method methodGet = cls.getDeclaredMethod(strGet);
			Object object = methodGet.invoke(obj);
			maps.put(name, object);
		}
		Set<String> keySet = maps.keySet();
		
	}
}
