package com.zxxz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxxz.constants.Constants;
import com.zxxz.utils.GsonUtils;
import com.zxxz.utils.HttpToolKit;
import com.zxxz.utils.JsonResponse;
@Controller
@RequestMapping(value = "/weather")
public class WeatherController {
	private static final String weatherUrl = "https://way.jd.com/he/freeweather";
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	
	@RequestMapping(value = "/queryWeatherMsg/v1.0", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getWeatherMsg(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		String city = request.getParameter("city");
		JsonResponse jsonResponse = null;
		if(StringUtils.isBlank(city)){
			logger.info("参数错误");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("city", city);
		params.put("appkey", Constants.jdSecret);
		String resp = HttpToolKit.doGet(weatherUrl, params);
		Map result = GsonUtils.fromJson(resp, Map.class);
		if(result!= null){
			jsonResponse=JsonResponse.buildSuccess("查询成功", result);
		}else{
			jsonResponse=JsonResponse.buildFailure("无结果");
		}
		return jsonResponse.toJsonString();
	}
}
