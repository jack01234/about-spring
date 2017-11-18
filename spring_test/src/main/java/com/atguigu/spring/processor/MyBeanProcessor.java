package com.atguigu.spring.processor;

import com.atguigu.spring.autowire.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public class MyBeanProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if ("car5".equals(s)) {
            System.out.println("postProcessBeforeInitialization>>>>>>>>>>>>>>>");
            Car car = (Car) o;
            car.setBrand("baoma");
            car.setPrice(300054);
            return car;
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if ("car5".equals(s)){
            System.out.println("postProcessAfterInitialization");
            Car car = (Car) o;
            car.setBrand("guangqi");
            car.setPrice(10000000);
            return car;
        }
        return o;
    }
}
