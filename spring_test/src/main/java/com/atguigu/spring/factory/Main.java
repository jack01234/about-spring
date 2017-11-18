package com.atguigu.spring.factory;

import com.atguigu.spring.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext app = new  ClassPathXmlApplicationContext("applicationContenxt_factory.xml");
        Car car = (Car) app.getBean("car1");
        System.out.println(car);

        Car object = (Car) app.getBean("carBeanFactory");
        System.out.println(object);
    }
}
