package com.wmli.jdbctest;


import com.wmli.JdbcUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.zip.InflaterInputStream;

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
        File file = new File("E://jdbc.properties");
        InputStream is = new FileInputStream(file);
        Properties p = new Properties();
        p.load(is);
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

    @Test
    public void testStatement() throws Exception {
        log.info("kaishi");
        Connection connection = null;
        Statement statement = null;
        try {
            //1.获取数据库链接
            connection = this.getConnection();

            //2.准备插入的SQL语句
            String sql = "INSERT INTO USER (NAME) VALUES ('liuxialai012');";
            //删除
            String sql2 = "delete user where id = 1;";
            log.info("sql = "+sql);
            //4.执行插入

            //1.>获取操作SQL语句的stateMent对象
            statement = connection.createStatement();
            //2.>调用connection的createStatement
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.关闭statement
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (connection != null)
                    connection.close();
            }
        }
        log.info(">>>>>jieshu<<<<<<");
    }

    @Test
    public void testStament1 (){
        String sql = "delete from user where id = 1;";
        update(sql);
    }
    public void update(String sql){
        log.info(">>>>>exceut sql sql = "+sql);
        Connection connection = null;
        Statement statement = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(null ,statement, connection);
        }
        log.info(">>>>>>>exceut end<<<<<<<<");
    }

    /**
     * ResultSet结果集，封装了JDBC进行查询结果
     * 1.调用statement获取结果集
     * 2.ResultSet 返回的实际上就是一张数据表，有一个指针只想数据表的第一样的前面
     */
    @Test
    public void testResultSet(){

        try {
            //1.获取连接
            Connection connection = JdbcUtil.getConnection();
            Statement statement = connection.createStatement();
            //准备SQL
            String sql = "select id,name from user where id = 4;";
            //执行查询
            ResultSet resultSet = statement.executeQuery(sql);
            //处理resultSet
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                log.info(">>>>查询结果为 id = "+id + " name = "+
                name);
            }
            JdbcUtil.release(resultSet,statement,connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
