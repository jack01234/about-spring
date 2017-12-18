package com.atguigu.spring.tx.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;
    //propagation= REQUIRES_NEW表示新建事务，每次方法执行完成就是一次事务，默认的是REQUIRED(有就行)
    @Transactional
    public void checkout(String username, List<String> isbns) {

        for (String isbn : isbns) {
            bookShopService.purchase(username,isbn);
        }
    }
}
