package com.atguigu.spring.factory;

import com.atguigu.spring.autowire.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public class StaticFactory {
    private static Map<String, Car> maps = new HashMap<String, Car>();

    /**
     * 静态方法
     */
    static {
        maps.put("aodi",new Car("aodi",1023024));
        maps.put("ford",new Car("ford",20123545));
    }
    public static Car getCar(String brand){
        return maps.get(brand);
    }
}
