package com.atguigu.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public class BaseService<T> {
    @Autowired
    private BaseRepository<T> repository;

    public void add(){
        System.out.println("add……");
        System.out.println(repository);
    }
}
