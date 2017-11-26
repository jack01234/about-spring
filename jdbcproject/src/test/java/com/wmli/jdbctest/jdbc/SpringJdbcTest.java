package com.wmli.jdbctest.jdbc;

import com.wmli.jdbctest.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class SpringJdbcTest extends BaseTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void getDataSource(){
        System.out.println(dataSource);

        System.out.print(jdbcTemplate);
    }
}
