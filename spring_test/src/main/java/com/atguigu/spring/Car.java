package com.atguigu.spring;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class Car {
    private String brand;
    private String corp;
    private int price;
    private double maxSpeed;

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, String corp, int price){
        super();
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public Car(String brand,String corp,double maxSpeed){
        super();
        this.brand = brand;
        this.corp = corp;
        this.maxSpeed = maxSpeed;
    }
    @Override
    public String toString(){
        return "Car [brand="+brand+",corp="+corp+", price="+price+", maxSpeed="+maxSpeed+"]";
    }
}
