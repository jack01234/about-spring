package com.atguigu.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;
    //事务的隔离级别,最常用的取值为READ_COMMITTED 读且提交
    //默认情况下spring的事务对所有的运行时异常进行回滚
    //noRollbackFor表示对那些异常不进行回滚
    //使用readOnly指定事务是否为只读
    //这样可以帮助数据库迎亲优化事务，若真的事一个只读取数据库值的方法，应设置为true
    //timeout事务的超时时间
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED,
    readOnly = false, timeout = 1)
    public void purchase(String username, String isbn) {
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //更新书的库存

        bookShopDao.updateBookStock(isbn);

        //更新账户余额

        bookShopDao.updateUserAcc(username,price);

    }
}
