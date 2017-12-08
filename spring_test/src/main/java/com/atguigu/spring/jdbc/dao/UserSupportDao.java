package com.atguigu.spring.jdbc.dao;

import com.atguigu.spring.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserSupportDao extends JdbcDaoSupport {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    public User getUserById(long id){
        this.setJdbcTemplate(jdbcTemplate);
        this.setDataSource(dataSource);
        String sql = "SELECT ID,NAME name,ADDRESS address FROM user WHERE ID = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
       return getJdbcTemplate().queryForObject(sql,rowMapper,id);
    }
}
