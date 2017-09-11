package cn.springmvc.service.impl;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@Component
public class HelloWorld {
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("hello " + name);
    }
}
