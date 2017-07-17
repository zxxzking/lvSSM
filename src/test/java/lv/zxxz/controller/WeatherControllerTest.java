package lv.zxxz.controller;

import lv.zxxz.common.TestBaseCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxxz.controller.WeatherController;


public class WeatherControllerTest extends TestBaseCase{
	@Autowired
	private WeatherController controller;

          
	@Test
	public void Test1(){
		request.setParameter("city", "上海");
		String msg = controller.getWeatherMsg(request, response);
		System.out.println(msg);
	}
}
