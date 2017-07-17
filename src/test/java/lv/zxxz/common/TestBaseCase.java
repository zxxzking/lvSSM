package lv.zxxz.common;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations = {"classpath:servlet-context.xml","classpath:root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBaseCase {
	// 模拟request,response  
    public MockHttpServletRequest request;  
    public MockHttpServletResponse response;  
    
    // 执行测试方法之前初始化模拟request,response  
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    }         
}
