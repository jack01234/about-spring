package com.atguigu.spring.autowire;

/**
 * Created by Administrator on 2017/11/8 0008.
 */
public class Car {
    private String brand;
    private double price;
    private double zhouchang;

    public void init(){
        System.out.println("初始化方法……");
    }
    public void destory(){
        System.out.println("销毁方法……");
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", zhouchang=" + zhouchang +
                '}';
    }

    public double getZhouchang() {
        return zhouchang;
    }

    public void setZhouchang(double zhouchang) {
        this.zhouchang = zhouchang;
    }

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
}
