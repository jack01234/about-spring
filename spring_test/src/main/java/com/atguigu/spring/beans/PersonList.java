package com.atguigu.spring.beans;

import com.atguigu.spring.Car;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
public class PersonList {

    private String name;

    private int age;

    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
