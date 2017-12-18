package com.atguigu.spring.tx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContenxt-dataSource.xml")
public class StringTransactionTest {

    @Autowired
    private BookShopDao bookShopDao;

    @Autowired
    private Cashier cashier;

    @Autowired
    private BookShopService bookShopService;
    @Test
    public void queryTest(){
        int bookPriceByIsbn = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println(bookPriceByIsbn);
    }

    @Test
    public void updateStockTest(){
        //检查库存是否足够

        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void updateUserAccTest(){
        bookShopDao.updateUserAcc("AA",300);

    }

    @Test
    public void purchTest(){
        bookShopService.purchase("AA","1001");
    }

    @Test
    public void transactionlPropagationTest(){
        cashier.checkout("AA", Arrays.asList("1001","1002"));
    }
}
