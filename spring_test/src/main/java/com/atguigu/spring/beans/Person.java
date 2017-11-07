package com.atguigu.spring.beans;

import com.atguigu.spring.Car;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
public class Person {

    private String name;
    private int age;
    private Car car;

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "name : "+name+" age : "+age+"car:"+car.toString();
    }
}
