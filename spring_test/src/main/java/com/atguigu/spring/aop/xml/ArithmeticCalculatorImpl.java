package com.atguigu.spring.aop.xml;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
@Qualifier("arithmeticCalculatorImpl")
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    public int add(int i, int j) {
        return i+j;
    }

    public int sub(int i, int j) {
        return i-j;
    }

    public int mul(int i, int j) {
        return i*j;
    }

    public int div(int i, int j) {
        return i/j;
    }
}
