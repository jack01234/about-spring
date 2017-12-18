package com.wmli.spring.jdbc;

import com.wmli.com.wmli.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public static void  add(final User user){
        String Sql = "INSERT INTO USER(id,name,address) VALUES(?,?,?)";
        jdbcTemplate.update(Sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,user.getId());
                ps.setString(2,user.getName());
                ps.setString(3,user.getAddress());
            }
        });
    }


//    public void update(int id){
//        String sql = "update user set name = ? , address = ? where id = ?";
//
//        jdbcTemplate.update(sql);
//    }

//    public User query(int id){
//        String sql = "select * from user where id = ?";
//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
//        return new JdbcOperations().queryForObject(sql,,id)
//    }
public static void main(String[] args) {
    User user = new User();
    user.setId(11);
    user.setName("aaaaaa");
    user.setAddress("dsfsdfs");
    add(user);
}
}
