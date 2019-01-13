package com.llnqdx.mvnproj.enjoy.concurrent01.ch3;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Auther: marvinmao
 * @Date: 2019/1/13
 * @Description:
 */
public class AtomicArray {
    static int[] value = new int[]{1, 2};

    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);

    }
}
