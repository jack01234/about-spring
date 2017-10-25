package com.atguigu.spring;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class HelloWorld {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public void sayHello(){
        System.out.println("hello "+name);
    }
}
