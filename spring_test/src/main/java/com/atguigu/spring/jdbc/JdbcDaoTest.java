package com.atguigu.spring.jdbc;

import com.atguigu.spring.beans.User;
import com.atguigu.spring.jdbc.dao.UserDao;
import com.atguigu.spring.jdbc.dao.UserSupportDao;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContenxt-dataSource.xml")
public class JdbcDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserSupportDao userSupportDao;

    @Test
    public void userDaoTest(){

        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void userDaoSupportTest(){
        User userById = userSupportDao.getUserById(2);

        System.out.println(userById);
    }
}
