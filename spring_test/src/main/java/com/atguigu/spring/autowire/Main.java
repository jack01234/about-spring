package com.atguigu.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/11/8 0008.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContenxt.xml");

        Person person4 = (Person) app.getBean("person4");
        System.out.println(person4.toString());
    }
}
