package com.atguigu.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class Main {
    public static void main(String[] args) {
        //加载spring配置文件
        ApplicationContext acx = new ClassPathXmlApplicationContext("applicationContenxt.xml");

        //获取IOC容器的中bean
        HelloWorld helloWorld = (HelloWorld) acx.getBean("helloWorld");

        helloWorld.sayHello();

        Car bean = (Car) acx.getBean("car");

        System.out.println(bean.toString());

        Car car = (Car) acx.getBean("car1");
        System.out.println(car.toString());
    }
}
