package com.atguigu.spring.factory;

import com.atguigu.spring.autowire.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public class CarBeanFactory implements FactoryBean<Car> {
    /**
     * 设置属性
     */
    private String brand;

    public Car getObject() throws Exception {
        return new Car("BMW",50000);
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
