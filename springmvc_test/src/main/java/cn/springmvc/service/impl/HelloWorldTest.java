package cn.springmvc.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public class HelloWorldTest {
    public static void main(String[] args) {
        //1.创建一个spring的IOC容器
        ApplicationContext context = new
                ClassPathXmlApplicationContext("config/applicationContenxt.xml");
        //2.从IOC容器中获取bean实例
       HelloWorld world = (HelloWorld) context.getBean("helloWorld");
       //3.调用相应的方法
        world.sayHello();
    }
}
