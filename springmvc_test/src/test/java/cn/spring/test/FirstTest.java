package cn.spring.test;

import cn.springmvc.dao.UserDao;
import cn.springmvc.model.User;
import cn.springmvc.service.impl.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private UserDao userDao;
    final Logger log = LoggerFactory.getLogger(FirstTest.class);
    @Test
    public void test(){
        log.info(">>>>>kaishi<<<<<<");
        helloWorld.sayHello();
    }
    @Test
    public void sqlTest(){
        log.info(">>>>>开始测试<<<<<");
        User user = new User();
        user.setName("liming");
        userDao.addUser(user);
        log.info(">>>>>结束测试<<<<<");
    }
}
