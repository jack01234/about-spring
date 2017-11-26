package com.wmli.jdbctest;

import com.wmli.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class JDBCTest2 {

    @Test
    public void preparedTest(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "INSERT INTO customers (NAME,email) VALUES(?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"liwenming");
            preparedStatement.setString(2,"1798204267@qq.com");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(null, preparedStatement,connection);
        }
    }


}
