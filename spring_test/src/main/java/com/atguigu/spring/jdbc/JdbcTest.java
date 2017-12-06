package com.atguigu.spring.jdbc;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {

    private ApplicationContext act = null;
    private JdbcTemplate jdbcTemplate = null;
    {
        act = new ClassPathXmlApplicationContext("applicationContenxt-dataSource.xml");
        jdbcTemplate = (JdbcTemplate) act.getBean("jdbcTemplate");
    }

    @Test
    public void dataSourceTest() throws SQLException {
        DataSource dataSource = (DataSource) act.getBean("dataSource");
        System.out.print(dataSource.getConnection());
    }

    @Test
    public void jdbcTemplateTest(){
        //更新
        String updateSql = "UPDATE USER SET NAME = ? WHERE ID = ?";
        int i = jdbcTemplate.update(updateSql, "wangdi", 1);
        System.out.println("更新结果："+i);

        //批量更新
        String insertSql = "INSERT INTO USER (ID,NAME,ADDRESS) VALUES(?,?,?)";
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{4,"AA","1235544"});
        objects.add(new Object[]{5,"AA","1235544"});
        objects.add(new Object[]{6,"AA","1235544"});
        objects.add(new Object[]{7,"AA","1235544"});
        objects.add(new Object[]{9,"AA","1235544"});
        int[] ints = jdbcTemplate.batchUpdate(insertSql, objects);
        System.out.print("批量更新结果："+ints.length);
    }
}
