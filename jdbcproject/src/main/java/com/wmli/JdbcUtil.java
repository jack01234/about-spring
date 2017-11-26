package com.wmli;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class JdbcUtil {

    /**
     * 获取数据库连接的方法
     * @return
     * @throws Exception
     */
    public static  Connection getConnection() throws Exception {
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

    /**
     * 关闭连接的方法
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
