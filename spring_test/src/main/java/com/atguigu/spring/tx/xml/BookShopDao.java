package com.atguigu.spring.tx.xml;

public interface BookShopDao {

    public int findBookPriceByIsbn(String isbn);


    public void updateBookStock(String isbn);

    public void updateUserAcc(String userName, int price);
}
