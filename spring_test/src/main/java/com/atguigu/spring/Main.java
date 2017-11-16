package com.atguigu.spring;

import com.atguigu.spring.beans.Person;
import com.atguigu.spring.beans.PersonList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

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
        Person person = (Person) acx.getBean("person");
        System.out.println(person.toString());
        Car car2 = (Car) acx.getBean("car2");
        System.out.println(car2.toString());
        PersonList personList = (PersonList) acx.getBean("personlist");
        System.out.println(personList);

        DataSource dataSource = (DataSource) acx.getBean("dataSource");
        System.out.println(dataSource);
    }
}
