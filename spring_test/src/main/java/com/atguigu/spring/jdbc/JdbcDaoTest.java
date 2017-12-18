package com.atguigu.spring.jdbc;

import com.atguigu.spring.beans.User;
import com.atguigu.spring.jdbc.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContenxt-dataSource.xml")
public class JdbcDaoTest {

    @Autowired
    private UserDao userDao;



    @Test
    public void userDaoTest(){

        User user = userDao.getUserById(1);
        System.out.println(user);
        userDao.insertByNameParam();
    }

    @Test
    public void userDaoTest1(){
        userDao.insertByParam1();
    }

}
