package com.atguigu.spring.tx.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContenxt-dataSource1.xml")
public class StringTractionTest {

    @Autowired
    private BookShopService bookShopService;

    @Test
    public void shopServiceTest(){
        bookShopService.purchase("AA","1001");
    }
}
