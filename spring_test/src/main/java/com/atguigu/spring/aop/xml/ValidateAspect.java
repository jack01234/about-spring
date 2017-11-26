package com.atguigu.spring.aop.xml;



import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class ValidateAspect {

    public void validate(JoinPoint joinPoint){
        System.out.print("validate"+ Arrays.asList(joinPoint.getArgs()));
    }
}
