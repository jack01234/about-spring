package com.atguigu.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContenxt-aopxml.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) app.getBean("arithmeticCalculator");

        int add = arithmeticCalculator.div(3, 1);

        System.out.println(add);
    }
}
