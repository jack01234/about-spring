package com.atguigu.spring.jdbc;

import com.atguigu.spring.beans.User;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.math.BigDecimal;
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


    @Test
    public void jdbcTemplateQueryTest(){



        //不支持级联属性
        String querySql = "SELECT ID,NAME name,ADDRESS address FROM user WHERE ID = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(querySql, rowMapper, 1);
        System.out.println(user);
        //查询list
        String listSql = "SELECT ID,NAME name,ADDRESS address FROM user WHERE ID > ?";
        RowMapper<User> listRowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(listSql,listRowMapper,1);
        System.out.println(users);

        //数量统计
        String countSql = "SELECT count(id) from USER";
        Long aLong = jdbcTemplate.queryForObject(countSql, Long.class);
        System.out.println("统计数量："+aLong);

    }
}
