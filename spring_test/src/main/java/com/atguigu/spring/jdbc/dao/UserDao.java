package com.atguigu.spring.jdbc.dao;

import com.atguigu.spring.beans.User;
import com.sun.org.apache.xpath.internal.axes.UnionPathIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public User getUserById(long id){
        String sql = "SELECT ID,NAME name,ADDRESS address FROM user WHERE ID = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return user;
    }

    /**
     * 使用具名函数来执行
     */
    public void insertByNameParam(){
        String sql = "INSERT INTO USER(ID,NAME,ADDRESS) VALUES(:id,:name,:address)";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",12);
        map.put("name","aaaaaaa");
        map.put("address","dddddddddddd");
        int update = namedParameterJdbcTemplate.update(sql, map);
        System.out.println("INSERT RESULT "+ update);
    }

    public void insertByParam1(){
        String sql = "INSERT INTO USER(ID,NAME,ADDRESS) VALUES(:id,:name,:address)";

        User user = new User();
        user.setAddress("123456789");
        user.setName("1234");
        user.setId(13);
        SqlParameterSource source = new BeanPropertySqlParameterSource(user);
        int update = namedParameterJdbcTemplate.update(sql, source);
        System.out.println(update);
    }
}
