package cn.spring.test;

import cn.springmvc.service.impl.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/applicationContenxt.xml")
public class FirstTest {
    @Autowired
    private HelloWorld helloWorld;
    @Test
    public void test(){
        helloWorld.sayHello();
    }
}
