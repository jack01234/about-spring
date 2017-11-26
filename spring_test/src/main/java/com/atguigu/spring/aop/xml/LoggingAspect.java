package com.atguigu.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
@Aspect
@Component
public class LoggingAspect {

    //日志切面配置
    public void before(JoinPoint joinPoint){
        System.out.println("the method "+joinPoint.getSignature().getName() +" begin with "+ Arrays.asList(joinPoint.getArgs()));
    }

    //日志切面配置
    public void after(JoinPoint joinPoint){
        System.out.println("the method "+joinPoint.getSignature().getName() +" end with "+ Arrays.asList(joinPoint.getArgs()));
    }

    //返回通知
    public Object afterReturn(JoinPoint joinPoint, Object result){
        System.out.println("the method "+joinPoint.getSignature().getName() +" end with "+ Arrays.asList(joinPoint.getArgs()));
        return result;
    }

    //异常通知
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        System.out.println("the method "+joinPoint.getSignature().getName() +" end with "+ ex);
    }

    //环绕通知
    //@Order注解表示切面的优先级值越小表示优先级越高@Around(value = "execution(* com.atguigu.spring.aop.*.*(int,int))")
    public Object around(ProceedingJoinPoint pjd){
        Object result = null;
        try {
            //前置通知
            System.out.println("the method "+pjd.getSignature().getName() +" begin with "+ Arrays.asList(pjd.getArgs()));
            result = pjd.proceed();
            System.out.println("the method "+pjd.getSignature().getName() +" end with "+ Arrays.asList(pjd.getArgs()));
        } catch (Throwable throwable) {
            System.out.println("the method "+pjd.getSignature().getName() +" end with "+ throwable);
            throw new RuntimeException(throwable);
        }
        System.out.println("the method "+pjd.getSignature().getName() +" end with "+ Arrays.asList(pjd.getArgs()));
        return result;
    }
}
