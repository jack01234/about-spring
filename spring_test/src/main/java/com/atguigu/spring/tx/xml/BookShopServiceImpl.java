package com.atguigu.spring.tx.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;
    public void purchase(String username, String isbn) {
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //更新书的库存

        bookShopDao.updateBookStock(isbn);

        //更新账户余额

        bookShopDao.updateUserAcc(username,price);

    }
}
