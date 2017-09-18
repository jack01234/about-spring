package com.wmli.jdbctest;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTest {
    private static Logger log = LoggerFactory.getLogger(JDBCTest.class);

    /**
     * Driver 是一个接口：数据库厂商必须提供实现的接口，能从其中获取数据库连接
     * 1.加载mysql驱动
     * 2.解压mysql-connector-java
     *
     *
     */
    @Test
    public void testDriver() throws Exception {
        Connection connect = this.getConnection();
        log.info("shuchu----->"+connect);

    }

    /**
     * 获取数据库连接的方法
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        String driverClass = null;
        String jdbcurl = null;
        String user = null;
        String password = null;
        //读取类路径下的properties文件
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties p = new Properties();
        p.load(resourceAsStream);
        driverClass =  p.getProperty("driverClass");
        jdbcurl = p.getProperty("jdbcurl");
        user = p.getProperty("user");
        password = p.getProperty("password");
        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Properties per = new Properties();
        per.put("user",user);
        per.put("password",password);
        Connection connection = driver.connect(jdbcurl,per);
        return connection;
    }
}
