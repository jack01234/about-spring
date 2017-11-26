package com.wmli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class JDBCTools {
    private static Logger log = LoggerFactory.getLogger(JDBCTools.class);

    /**
     * prestatment的更新方法
     * @param sql sql语句
     */
    public static void update(String sql, Object ... args){
        log.info(">>>>>exceut sql sql = "+sql);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++){
                statement.setObject(i+1,args[i]);
            }
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(null ,statement, connection);
        }
        log.info(">>>>>>>exceut end<<<<<<<<");
    }
}
