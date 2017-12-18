package com.atguigu.spring.tx.xml;

import com.atguigu.spring.tx.BookStockException;
import com.atguigu.spring.tx.UserAccException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM book where isbn = ?";
//        RowMapper rowMapper = new BeanPropertyRowMapper();
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    public void updateBookStock(String isbn) {
        //检查库存是否足够
        String sql2 = "SELECT stock From book_stock where isbn = ?";
        Integer stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (stock<=0) {
            //库存不足
            throw  new BookStockException("库存不足");
        }
        String sql = "UPDATE book_stock set stock = stock-1 where isbn = ?";
        jdbcTemplate.update(sql,isbn);

    }

    public void updateUserAcc(String userName, int price) {
        String sql2 = "SELECT balance FROM account where username = ?";
        Integer balance = jdbcTemplate.queryForObject(sql2, Integer.class, userName);
        if (balance < price) {
            throw new UserAccException("余额不足");
        }
        String sql = "UPDATE account set balance = balance - ? where username = ?";
        int update = jdbcTemplate.update(sql, price, userName);
        System.out.println(update);
    }
}
