package com.llnqdx.mvnproj.enjoy.concurrent01.ch3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/13
 * @Description:
 */
public class UseAtomicInt {

    static AtomicInteger ai = new AtomicInteger(10);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());//10--->11
        System.out.println(ai.incrementAndGet());//11--->12--->out
        System.out.println(ai.get());
    }
}
