package com.wmli.spring.jdbc;

import com.wmli.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        try {
            String sql = "INSERT INTO USER (ID,NAME,ADDRESS) VALUES(?,?,?)";
            Connection connection = JdbcUtil.getConnection();
            //创建语句
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,10);
            preparedStatement.setString(2,"lllllllll");
            preparedStatement.setString(3,"ssssssssssssssss");
            preparedStatement.execute();
            JdbcUtil.release(null,preparedStatement,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
