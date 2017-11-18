package com.atguigu.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 4.0新特性，泛型依赖注入：当泛型的父类建立关系之后，子类之间也存在着一种关系
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContenxt-annotation.xml");
        UserService service = (UserService) app.getBean("userService");
        System.out.println(service);
        service.add();
    }
}
