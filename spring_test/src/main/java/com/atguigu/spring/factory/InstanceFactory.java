package com.atguigu.spring.factory;

import com.atguigu.spring.autowire.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public class InstanceFactory {
    private Map<String, Car> maps = null;

    public InstanceFactory(){
        maps = new HashMap<String, Car>();
        maps.put("aodi",new Car("aodi",56987));
        maps.put("ford",new Car("ford",89765));
    }
    public Car getCar(String name){
        return maps.get(name);
    }
}
